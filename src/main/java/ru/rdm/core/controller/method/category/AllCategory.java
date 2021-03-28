package ru.rdm.core.controller.method.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.CategoryReq;
import ru.rdm.core.controller.dto.response.CategoryRes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ru.rdm.core.enums.CategoryType.*;

@Component("category")
@Slf4j
public class AllCategory extends Category{

    @Override
    public CategoryRes execute(CategoryReq req) {
        log.info("start category {}", req);
        CategoryRes res = new CategoryRes();
        List<ru.rdm.core.database.dao.Category> mainCats = categoryRepository.findByParentIdAndTypeOrderByPriority(0L, CATEGORY.getType());
        if (checkList(mainCats)){
            List<ru.rdm.core.database.dao.Category> childCats = categoryRepository.findByParentIdInAndTypeOrderByPriority(
                    mainCats.stream().map(ru.rdm.core.database.dao.Category::getCategoryId).collect(Collectors.toList()), SUBCATEGORY.getType()
            );
            if (checkList(childCats)) {
                List<ru.rdm.core.controller.dto.support.Category> mainList = new ArrayList<>();
                for (ru.rdm.core.database.dao.Category item : mainCats) {
                    ru.rdm.core.controller.dto.support.Category cat = getCategory(item);
                    List<ru.rdm.core.controller.dto.support.Category> l = new ArrayList<>();
                    for(ru.rdm.core.database.dao.Category item2 : childCats) {
                        if (item.getCategoryId().equals(item.getParentId())) {
                            ru.rdm.core.controller.dto.support.Category cat2 = getCategory(item2);
                            l.add(cat2);
                        }
                    }
                    if (checkList(l))
                        cat.setChilds(l);
                    mainList.add(cat);
                }
                res.setList(mainList);
            }
        }
        log.info("end category {}", req);
        return res;
    }
}

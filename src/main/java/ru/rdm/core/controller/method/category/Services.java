package ru.rdm.core.controller.method.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.CategoryReq;
import ru.rdm.core.controller.dto.response.CategoryRes;
import ru.rdm.core.enums.CategoryType;

import java.util.List;
import java.util.stream.Collectors;

@Component("services")
@Slf4j
public class Services extends Category{

    @Override
    public CategoryRes execute(CategoryReq req) {
        log.info("start services {}", req);
        CategoryRes res = new CategoryRes();
        List<ru.rdm.core.database.dao.Category> services = categoryRepository.findByParentIdInAndTypeOrderByPriority(req.getCategory()
                , CategoryType.SERVICE.getType());
        if (checkList(services)){
            res.setList(services.stream().map(this::getCategory).collect(Collectors.toList()));
        }
        log.info("end services {}", req);
        return res;
    }
}

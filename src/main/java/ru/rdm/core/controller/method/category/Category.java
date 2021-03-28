package ru.rdm.core.controller.method.category;

import org.springframework.beans.factory.annotation.Autowired;
import ru.rdm.core.controller.dto.request.CategoryReq;
import ru.rdm.core.controller.dto.response.CategoryRes;
import ru.rdm.core.database.repository.CategoryRepository;
import ru.rdm.core.enums.CategoryType;
import ru.rdm.core.security.jwt.JwtTokenBuilder;

import java.util.List;

public abstract class Category {

    @Autowired
    protected CategoryRepository categoryRepository;
    @Autowired
    private JwtTokenBuilder jwtTokenBuilder;

    public abstract CategoryRes execute(CategoryReq req);

    protected boolean checkList(List<?> list){
        return list != null && list.size() > 0;
    }

    protected ru.rdm.core.controller.dto.support.Category getCategory(ru.rdm.core.database.dao.Category item){
        ru.rdm.core.controller.dto.support.Category c = new ru.rdm.core.controller.dto.support.Category();
        c.setLogo(item.getLogoFile());
        c.setId(item.getCategoryId());
        c.setName(item.getCategoryName());
        c.setDescription(item.getDescription());
        if (item.getType().equals(CategoryType.SERVICE.getType()))
            c.setCategory(item.getParentId());
        return c;
    }

    protected Long getLocationId(CategoryReq req){
        return (Long) jwtTokenBuilder.getParamFromToken(req.getAuth(), "locationId");
    }

}
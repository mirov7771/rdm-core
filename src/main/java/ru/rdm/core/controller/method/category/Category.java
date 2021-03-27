package ru.rdm.core.controller.method.category;

import ru.rdm.core.controller.dto.request.CategoryReq;
import ru.rdm.core.controller.dto.response.CategoryRes;

public abstract class Category {

    public abstract CategoryRes execute(CategoryReq req);
}
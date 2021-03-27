package ru.rdm.core.controller.service;

import ru.rdm.core.controller.dto.request.CategoryReq;
import ru.rdm.core.controller.dto.response.CategoryRes;

public interface CategoryService {

    CategoryRes category(CategoryReq req, String method);

}

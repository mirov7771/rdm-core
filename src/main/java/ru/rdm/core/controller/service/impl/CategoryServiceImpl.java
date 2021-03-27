package ru.rdm.core.controller.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rdm.core.controller.dto.request.CategoryReq;
import ru.rdm.core.controller.dto.response.CategoryRes;
import ru.rdm.core.controller.method.category.Category;
import ru.rdm.core.controller.service.CategoryService;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final Map<String, Category> categories;

    @Override
    public CategoryRes category(CategoryReq req, String method) {
        return categories.get(method).execute(req);
    }
}

package ru.rdm.core.controller.dto.response;

import lombok.Data;
import ru.rdm.core.controller.dto.support.Category;

import java.util.List;

@Data
public class CategoryRes {

    private List<Category> list;

}

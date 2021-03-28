package ru.rdm.core.controller.dto.support;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Category {

    private Long id;
    private String name;
    private String logo;
    private String description;
    private Long category;
    private List<Category> childs;

}

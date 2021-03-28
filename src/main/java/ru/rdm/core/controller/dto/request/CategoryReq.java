package ru.rdm.core.controller.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CategoryReq {

    private List<Long> category;

}

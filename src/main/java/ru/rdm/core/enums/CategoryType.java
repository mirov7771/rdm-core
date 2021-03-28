package ru.rdm.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {

    CATEGORY(0),
    SUBCATEGORY(1),
    SERVICE(2);

    private final Integer type;

}

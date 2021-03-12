package ru.rdm.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {

    PROHIBITED(1000, 404, "Сервис временно недоступен", null);

    private final Integer code;
    private final Integer status;
    private final String message;
    private final String details;

}

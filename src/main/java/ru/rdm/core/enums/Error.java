package ru.rdm.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {

    PROHIBITED(1000, 406, "Сервис временно недоступен", null),
    INVALID_SESSION(1001, 401, "Invalid session", null),
    INVALID_OTP(1002, 404, "Неверный код подтверждения", null);

    private final Integer code;
    private final Integer status;
    private final String message;
    private final String details;

}

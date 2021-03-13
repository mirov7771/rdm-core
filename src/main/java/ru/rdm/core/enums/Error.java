package ru.rdm.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {

    PROHIBITED(1000, 406, "Сервис временно недоступен"),
    INVALID_SESSION(1001, 401, "Invalid session"),
    INVALID_OTP(1002, 404, "Неверный код подтверждения"),
    REQUIRED_PARAMS(1003, 406, "Не переданы обязательные параметры");

    private final Integer code;
    private final Integer status;
    private final String message;

}

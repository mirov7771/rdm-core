package ru.rdm.core.controller.dto.support;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ErrorRes {

    private Integer code;
    private String message;
    private String details;

    public ErrorRes(Integer code, String message, String details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }
}

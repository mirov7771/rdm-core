package ru.rdm.core.controller.util;

import org.springframework.http.ResponseEntity;
import ru.rdm.core.controller.dto.support.ErrorRes;
import ru.rdm.core.enums.Error;

public class ControllerUtil {

    public static ResponseEntity<?> success(Object data) {
        return ResponseEntity.ok().body(data);
    }

    public static ResponseEntity<ErrorRes> error(Error error) {
        return ResponseEntity.status(error.getStatus())
                .body(new ErrorRes(error.getCode(), error.getMessage()));
    }

}

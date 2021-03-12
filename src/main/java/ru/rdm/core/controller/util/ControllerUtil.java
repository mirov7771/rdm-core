package ru.rdm.core.controller.util;

import org.springframework.http.ResponseEntity;

public class ControllerUtil {

    public static ResponseEntity<?> success(Object data) {
        return ResponseEntity.ok().body(data);
    }

}

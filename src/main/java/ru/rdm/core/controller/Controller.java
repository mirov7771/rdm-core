package ru.rdm.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rdm.core.controller.dto.request.AuthReq;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";

    @GetMapping(value = "/auth/check", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> check(@RequestHeader("access_token") String accessToken)
    {
        return null;
    }

    @PostMapping(value = "/auth/login", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> login(@RequestBody AuthReq req)
    {
        return null;
    }

    @PostMapping(value = "/auth/code", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> code(@RequestBody AuthReq req)
    {
        return null;
    }

    @PostMapping(value = "/auth/token", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> token(@RequestBody AuthReq req)
    {
        return null;
    }

}

package ru.rdm.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.service.AuthService;
import ru.rdm.core.controller.util.ControllerUtil;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";

    private final AuthService authService;

    @GetMapping(value = "/auth/check", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> check(@RequestHeader("access_token") String accessToken)
    {
        AuthReq req = new AuthReq();
        req.setAccessToken(accessToken);
        return ControllerUtil.success(authService.auth(req, "check"));
    }

    @PostMapping(value = "/auth/login", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> login(@RequestBody AuthReq req)
    {
        return ControllerUtil.success(authService.auth(req, "login"));
    }

    @PostMapping(value = "/auth/code", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> code(@RequestBody AuthReq req)
    {
        return ControllerUtil.success(authService.auth(req, "code"));
    }

    @PostMapping(value = "/auth/token", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> token(@RequestBody AuthReq req)
    {
        return ControllerUtil.success(authService.auth(req, "token"));
    }

}

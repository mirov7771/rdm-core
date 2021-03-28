package ru.rdm.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.request.CategoryReq;
import ru.rdm.core.controller.dto.request.ReferenceReq;
import ru.rdm.core.controller.service.AuthService;
import ru.rdm.core.controller.service.CategoryService;
import ru.rdm.core.controller.util.ServiceUtil;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";

    private final AuthService authService;
    private final CategoryService categoryService;

    /**
     * 1. Авторизация
     */
    @GetMapping(value = "/auth/check", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> check(@RequestHeader("access_token") String accessToken)
    {
        AuthReq req = new AuthReq();
        req.setAccessToken(accessToken);
        return ServiceUtil.success(authService.auth(req, "check"));
    }

    @PostMapping(value = "/auth/login", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> login(@RequestBody AuthReq req)
    {
        return ServiceUtil.success(authService.auth(req, "login"));
    }

    @PostMapping(value = "/auth/code", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> code(@RequestBody AuthReq req)
    {
        return ServiceUtil.success(authService.auth(req, "code"));
    }

    @PostMapping(value = "/auth/token", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> token(@RequestBody AuthReq req)
    {
        return ServiceUtil.success(authService.auth(req, "token"));
    }

    /**
     * 2. Категории/подкатегории/услуги
     */
    @GetMapping(value = "/category", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> category(@RequestHeader("Authorization") String authorization
                                     ,CategoryReq req)
    {
        req.setAuth(authorization);
        return ServiceUtil.success(categoryService.category(req, "category"));
    }

    @GetMapping(value = "/services", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> services(@RequestHeader("Authorization") String authorization
                                     ,CategoryReq req)
    {
        req.setAuth(authorization);
        return ServiceUtil.success(categoryService.category(req, "services"));
    }

    /**
     * 3. Справочники
     */
    @GetMapping(value = "/region", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> region(ReferenceReq req)
    {
        return ServiceUtil.success(null);
    }

}

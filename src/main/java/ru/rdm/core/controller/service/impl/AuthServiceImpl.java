package ru.rdm.core.controller.service.impl;

import org.springframework.stereotype.Service;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;
import ru.rdm.core.controller.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthRes check(String accessToken) {
        return null;
    }

    @Override
    public AuthRes login(AuthReq req) {
        return null;
    }

    @Override
    public AuthRes code(AuthReq req) {
        return null;
    }

    @Override
    public AuthRes token(AuthReq req) {
        return null;
    }
}

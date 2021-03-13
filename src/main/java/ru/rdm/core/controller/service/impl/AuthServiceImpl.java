package ru.rdm.core.controller.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;
import ru.rdm.core.controller.method.auth.Auth;
import ru.rdm.core.controller.service.AuthService;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final Map<String, Auth> authMethod;

    @Override
    public AuthRes auth(AuthReq req, String method) {
        return authMethod.get(method).execute(req);
    }
}

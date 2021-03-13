package ru.rdm.core.controller.service;

import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;

public interface AuthService {

    AuthRes check(String accessToken);
    AuthRes login(AuthReq req);
    AuthRes code(AuthReq req);
    AuthRes token(AuthReq req);

}

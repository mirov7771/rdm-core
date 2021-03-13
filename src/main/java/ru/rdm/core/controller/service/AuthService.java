package ru.rdm.core.controller.service;

import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;

public interface AuthService {

    AuthRes auth(AuthReq req, String method);

}

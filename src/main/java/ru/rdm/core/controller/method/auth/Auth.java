package ru.rdm.core.controller.method.auth;

import org.springframework.beans.factory.annotation.Autowired;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;
import ru.rdm.core.database.repository.UserProfileRepository;
import ru.rdm.core.database.repository.UserSessionRepository;

public abstract class Auth {

    @Autowired
    protected UserSessionRepository userSessionRepository;
    @Autowired
    protected UserProfileRepository userProfileRepository;

    public abstract AuthRes execute(AuthReq req);

}

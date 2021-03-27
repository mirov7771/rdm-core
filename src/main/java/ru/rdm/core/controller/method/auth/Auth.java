package ru.rdm.core.controller.method.auth;

import org.springframework.beans.factory.annotation.Autowired;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;
import ru.rdm.core.database.dao.UserSession;
import ru.rdm.core.database.repository.UserProfileRepository;
import ru.rdm.core.database.repository.UserSessionRepository;
import ru.rdm.core.enums.Error;
import ru.rdm.core.enums.Status;
import ru.rdm.core.exception.RdmException;
import ru.rdm.core.security.jwt.JwtTokenBuilder;

import java.util.Date;

public abstract class Auth {

    @Autowired
    protected UserSessionRepository userSessionRepository;
    @Autowired
    protected UserProfileRepository userProfileRepository;
    @Autowired
    protected JwtTokenBuilder jwtTokenBuilder;

    public abstract AuthRes execute(AuthReq req);

    protected UserSession checkTempSession(AuthReq req, String method) {
        UserSession session;
        if ("byCode".equals(method)) {
            session = userSessionRepository.findBySessionIdAndCodeAndExpiryAfter(req.getSessionId(), req.getCode(), new Date());
        } else {
            session = userSessionRepository.findBySessionIdAndExpiryAfter(req.getSessionId(), new Date());
        }
        if (session == null || session.getSessionId() == null)
            throw new RdmException(Error.INVALID_SESSION);
        return session;
    }

    protected Status needQuestion(boolean b){
        return Boolean.TRUE.equals(b) ? Status.OK : Status.QUESTION;
    }

}

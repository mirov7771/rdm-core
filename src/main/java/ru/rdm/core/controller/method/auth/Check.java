package ru.rdm.core.controller.method.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;
import ru.rdm.core.controller.dto.support.Client;
import ru.rdm.core.database.dao.UserProfile;
import ru.rdm.core.database.dao.UserSession;
import ru.rdm.core.enums.Error;
import ru.rdm.core.exception.RdmException;

import java.util.Date;

@Component("check")
@Slf4j
public class Check extends Auth {

    @Override
    public AuthRes execute(AuthReq req) {
        log.info("start check {}", req);
        AuthRes res = new AuthRes();
        UserProfile user = getUserProfile(req.getAccessToken());
        res.setStatus(needQuestion(user.getAsked()));
        Client c = new Client();
        c.setEmail(user.getEmail());
        c.setFio(user.getFio());
        c.setLocation(user.getLocation());
        c.setLocationId(user.getLocationId());
        res.setClient(c);
        log.info("end check {}", res);
        return res;
    }

    private UserProfile getUserProfile(String token){
        UserSession session = userSessionRepository.findByAccessTokenAndExpiryAfter(token, new Date());
        if (session == null || session.getSessionId() == null)
            throw new RdmException(Error.INVALID_SESSION);
        UserProfile user = userProfileRepository.findByUserId(session.getUserId());
        if (user == null || user.getUserId() == null)
            throw new RdmException(Error.INVALID_SESSION);
        return user;
    }

    public boolean checkSession(String token){
        UserProfile user = getUserProfile(token);
        return user.getAsked();
    }
}

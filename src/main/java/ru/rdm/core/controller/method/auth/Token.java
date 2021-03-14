package ru.rdm.core.controller.method.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;
import ru.rdm.core.controller.util.ServiceUtil;
import ru.rdm.core.database.dao.UserProfile;
import ru.rdm.core.database.dao.UserSession;
import ru.rdm.core.enums.Error;
import ru.rdm.core.exception.RdmException;

@Component("token")
@Slf4j
public class Token extends Auth {

    @Value("${application.timeout.client:30}")
    private int clientTimeOut;

    @Override
    public AuthRes execute(AuthReq req) {
        log.info("start token {}", req);
        UserSession session = checkTempSession(req, "byCode");
        AuthRes res = new AuthRes();
        UserProfile profile = userProfileRepository.findByUserId(session.getUserId());
        if (profile == null || profile.getUserId() == null)
            throw new RdmException(Error.INVALID_SESSION);
        String token = jwtTokenBuilder.buildToken(profile);
        res.setAccessToken(token);
        res.setStatus(needQuestion(profile.getAsked()));
        session.setAccessToken(token);
        session.setExpiry(ServiceUtil.getExpiry(clientTimeOut));
        userSessionRepository.save(session);
        log.info("end token {}", res);
        return res;
    }
}

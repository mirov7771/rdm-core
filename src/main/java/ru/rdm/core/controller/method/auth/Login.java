package ru.rdm.core.controller.method.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.request.OtpReq;
import ru.rdm.core.controller.dto.response.AuthRes;
import ru.rdm.core.controller.method.otp.Create;
import ru.rdm.core.controller.util.ServiceUtil;
import ru.rdm.core.database.dao.UserSession;
import ru.rdm.core.enums.OtpType;

@Component("login")
@Slf4j
public class Login extends Auth {

    @Autowired
    private Create createSms;

    @Value("${application.timeout.temp}")
    private int tempTimeOut;

    @Override
    public AuthRes execute(AuthReq req) {
        log.info("start login {}", req);
        AuthRes res = new AuthRes();
        userSessionRepository.deleteByPhone(req.getPhone());
        String sessionId = jwtTokenBuilder.buildSession();
        OtpReq otpReq = new OtpReq();
        otpReq.setPhone(req.getPhone());
        otpReq.setType(OtpType.LOGIN.getType());
        createSms.execute(otpReq);
        UserSession session = new UserSession();
        session.setSessionId(sessionId);
        session.setPhone(req.getPhone());
        session.setExpiry(ServiceUtil.getExpiry(tempTimeOut));
        userSessionRepository.save(session);
        res.setSessionId(sessionId);
        log.info("end login {}", res);
        return res;
    }
}

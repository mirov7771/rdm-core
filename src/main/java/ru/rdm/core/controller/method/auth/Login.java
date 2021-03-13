package ru.rdm.core.controller.method.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;
import ru.rdm.core.database.repository.OtpCodeRepository;

@Component("login")
@Slf4j
public class Login extends Auth {

    @Autowired
    private OtpCodeRepository otpCodeRepository;

    @Override
    public AuthRes execute(AuthReq req) {
        log.info("start login {}", req);
        AuthRes res = new AuthRes();
        log.info("end login {}", res);
        return res;
    }
}

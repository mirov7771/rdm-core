package ru.rdm.core.controller.method.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;

@Component("token")
@Slf4j
public class Token extends Auth {

    @Override
    public AuthRes execute(AuthReq req) {
        log.info("start token {}", req);
        checkTempSession(req, "byCode");
        AuthRes res = new AuthRes();
        log.info("end token {}", res);
        return res;
    }
}

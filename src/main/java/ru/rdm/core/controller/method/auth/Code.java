package ru.rdm.core.controller.method.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;

@Component("code")
@Slf4j
public class Code extends Auth {

    @Override
    public AuthRes execute(AuthReq req) {
        log.info("start code {}", req);
        AuthRes res = new AuthRes();
        log.info("end code {}", res);
        return res;
    }
}

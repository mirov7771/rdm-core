package ru.rdm.core.controller.method.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.response.AuthRes;

@Component("check")
@Slf4j
public class Check extends Auth {

    @Override
    public AuthRes execute(AuthReq req) {
        log.info("start check {}", req);
        AuthRes res = new AuthRes();
        log.info("end check {}", res);
        return res;
    }
}

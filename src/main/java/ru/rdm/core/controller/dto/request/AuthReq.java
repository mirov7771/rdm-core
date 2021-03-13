package ru.rdm.core.controller.dto.request;

import lombok.Data;
import ru.rdm.core.controller.dto.support.Client;

@Data
public class AuthReq {

    private String phone;
    private String sessionId;
    private String otp;
    private Client client;
    private String code;

}

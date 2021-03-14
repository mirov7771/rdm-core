package ru.rdm.core.controller.method.otp;

import org.springframework.beans.factory.annotation.Autowired;
import ru.rdm.core.controller.dto.request.OtpReq;
import ru.rdm.core.controller.dto.response.OtpRes;
import ru.rdm.core.database.repository.OtpCodeRepository;

public abstract class Otp {

    @Autowired
    protected OtpCodeRepository otpCodeRepository;

    public abstract OtpRes execute(OtpReq req);

}

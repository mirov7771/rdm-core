package ru.rdm.core.controller.method.otp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.OtpReq;
import ru.rdm.core.controller.dto.response.OtpRes;
import ru.rdm.core.database.dao.OtpCode;
import ru.rdm.core.enums.Error;
import ru.rdm.core.enums.Status;
import ru.rdm.core.exception.RdmException;

import java.util.Date;

@Component("confirm")
@Slf4j
public class Confirm extends Otp {

    @Override
    public OtpRes execute(OtpReq req) {
        log.info("start confirm {}", req);
        OtpRes res = new OtpRes();
        OtpCode code = otpCodeRepository.findByCodeAndPhoneAndTypeAndExpiryAfter(req.getCode(),
                req.getPhone(),
                req.getType(),
                new Date());
        if (code == null)
            throw new RdmException(Error.INVALID_OTP);
        otpCodeRepository.deleteByPhoneAndType(req.getPhone(), req.getType());
        res.setStatus(Status.OK);
        log.info("end confirm {}", res);
        return res;
    }
}

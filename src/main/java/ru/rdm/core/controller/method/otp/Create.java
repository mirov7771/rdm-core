package ru.rdm.core.controller.method.otp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.OtpReq;
import ru.rdm.core.controller.dto.response.OtpRes;
import ru.rdm.core.controller.util.ServiceUtil;
import ru.rdm.core.database.dao.OtpCode;
import ru.rdm.core.enums.OtpType;

import java.util.Random;

@Component("create")
@Slf4j
public class Create extends Otp {

    @Value("${application.timeout.sms}")
    public int smsTimeOut;

    @Override
    public OtpRes execute(OtpReq req) {
        log.info("start create {}", req);
        OtpRes res = new OtpRes();
        otpCodeRepository.deleteByPhoneAndType(req.getPhone(), req.getType());
        String code = createCode();
        //TO добавить сервис по отправке СМС сообщения
        otpCodeRepository.save(new OtpCode(code
                , req.getPhone()
                , OtpType.LOGIN.getType()
                , ServiceUtil.getExpiry(smsTimeOut)));
        log.info("end create {}", res);
        return res;
    }

    private String createCode(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            String s1 = rand.nextInt(10)+"";
            sb.append(s1, 0, 1);
        }
        return sb.toString();
    }
}

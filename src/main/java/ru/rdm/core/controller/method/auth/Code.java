package ru.rdm.core.controller.method.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.AuthReq;
import ru.rdm.core.controller.dto.request.OtpReq;
import ru.rdm.core.controller.dto.response.AuthRes;
import ru.rdm.core.controller.method.otp.Confirm;
import ru.rdm.core.database.dao.UserProfile;
import ru.rdm.core.database.dao.UserSession;
import ru.rdm.core.enums.Error;
import ru.rdm.core.enums.OtpType;
import ru.rdm.core.enums.Status;
import ru.rdm.core.enums.UserRole;
import ru.rdm.core.exception.RdmException;

import java.util.UUID;

@Component("code")
@Slf4j
public class Code extends Auth {

    @Autowired
    private Confirm confirmSms;

    @Override
    public AuthRes execute(AuthReq req) {
        log.info("start code {}", req);
        UserSession session = checkTempSession(req, "bySession");
        AuthRes res = new AuthRes();
        if (req.getOtp() != null)
            smsCheck(res, req, session);
        else if (req.getClient() != null)
            createClient(res, req, session);
        else
            throw new RdmException(Error.REQUIRED_PARAMS);
        log.info("end code {}", res);
        return res;
    }

    private void smsCheck(AuthRes res, AuthReq req, UserSession session){
        confirmSms.execute(new OtpReq(req.getOtp(), session.getPhone(), OtpType.LOGIN.getType()));
        UserProfile profile = userProfileRepository.findByPhone(session.getPhone());
        if (profile == null || profile.getUserId() == null){
            res.setStatus(Status.NEWCLIENT);
        } else {
            res.setStatus(Status.OK);
            updateSession(session, profile);
            res.setCode(session.getCode());
        }
    }

    private void createClient(AuthRes res, AuthReq req, UserSession session){
        res.setStatus(Status.OK);
        UserProfile profile = userProfileRepository.save(new UserProfile(session.getPhone()
                , req.getClient()
                , UserRole.CLIENT));
        updateSession(session, profile);
        res.setCode(session.getCode());
    }

    private void updateSession(UserSession session, UserProfile profile){
        session.setUserId(profile.getUserId());
        session.setCode(UUID.randomUUID().toString());
        userSessionRepository.save(session);
    }


}

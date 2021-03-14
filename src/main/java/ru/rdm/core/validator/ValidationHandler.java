package ru.rdm.core.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rdm.core.controller.dto.support.ErrorRes;
import ru.rdm.core.controller.util.ServiceUtil;
import ru.rdm.core.enums.Error;
import ru.rdm.core.exception.RdmException;

@ControllerAdvice
@Slf4j
public class ValidationHandler {

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<ErrorRes> handleException(Exception ex) {
        log.error("error in service", ex);
        if (ex instanceof RdmException){
            RdmException e = (RdmException) ex;
            Error error = e.getError();
            return ServiceUtil.error(error);
        } else if (ex instanceof MissingRequestHeaderException){
            return ServiceUtil.error(Error.REQUIRED_PARAMS);
        }
        return ServiceUtil.error(Error.PROHIBITED);
    }

}

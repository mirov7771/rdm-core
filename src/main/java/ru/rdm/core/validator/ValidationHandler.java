package ru.rdm.core.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rdm.core.controller.dto.support.ErrorRes;
import ru.rdm.core.enums.Error;
import ru.rdm.core.exception.RdmException;

@Component
@Slf4j
public class ValidationHandler {

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<ErrorRes> handleException(Exception ex) {
        log.error("error in service", ex);
        if (ex instanceof RdmException){
            RdmException e = (RdmException) ex;
            Error error = e.getError();
            return ResponseEntity.status(error.getStatus()).body(new ErrorRes(error.getCode(), e.getMessage(), error.getDetails()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorRes(1000, "Сервис временно недоступен", ex.getMessage()));
    }

}

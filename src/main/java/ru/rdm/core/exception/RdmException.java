package ru.rdm.core.exception;

import lombok.Getter;
import ru.rdm.core.enums.Error;

@Getter
public class RdmException  extends RuntimeException {

    private static final long serialVersionUID = 8359430630502179416L;

    private final Error error;

    public RdmException(Error error, String message){
        super(message);
        this.error = error;
    }

}

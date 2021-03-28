package ru.rdm.core.controller.method.reference;

import ru.rdm.core.controller.dto.request.ReferenceReq;
import ru.rdm.core.controller.dto.response.ReferenceRes;

public abstract class Reference {

    public abstract ReferenceRes execute(ReferenceReq req);

    protected boolean checkValue(String val){
        return val != null && !"".equals(val);
    }

}

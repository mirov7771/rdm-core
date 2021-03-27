package ru.rdm.core.controller.method.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.CategoryReq;
import ru.rdm.core.controller.dto.response.CategoryRes;

@Component("services")
@Slf4j
public class Services extends Category{

    @Override
    public CategoryRes execute(CategoryReq req) {
        log.info("start services {}", req);
        CategoryRes res = new CategoryRes();
        log.info("end services {}", req);
        return res;
    }
}

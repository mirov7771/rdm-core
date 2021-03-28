package ru.rdm.core.controller.method.reference;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.rdm.core.controller.dto.request.ReferenceReq;
import ru.rdm.core.controller.dto.response.ReferenceRes;
import ru.rdm.core.database.repository.RegionRepository;

import java.util.List;

@Component("region")
@RequiredArgsConstructor
@Slf4j
public class Region extends Reference {

    private final RegionRepository regionRepository;

    @Override
    public ReferenceRes execute(ReferenceReq req) {
        log.info("start region {}", req);
        ReferenceRes res = new ReferenceRes();
        List<ru.rdm.core.database.dao.Region> dbList;
        if (checkValue(req.getName())){
            dbList = regionRepository.findByRegionNameLike("%"+req.getName()+"%");
        } else {
            dbList = (List<ru.rdm.core.database.dao.Region>) regionRepository.findAll();
        }
        res.setList(dbList);
        log.info("end region {}", req);
        return res;
    }
}

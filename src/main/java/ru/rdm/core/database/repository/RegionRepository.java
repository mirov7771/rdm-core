package ru.rdm.core.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rdm.core.database.dao.Region;

import java.util.List;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {

    List<Region> findByRegionNameLike(String regionName);

}

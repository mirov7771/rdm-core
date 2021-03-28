package ru.rdm.core.database.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rdm.core.database.dao.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query(value = "select c.* from category c,region_link l where c.categoryid = l.childid and c.parentid in (:parentIds) and c.type = :type and l.regionid = :regionId"
            , nativeQuery = true)
    List<Category> find(@Param("parentId") List<Long> parentIds
            , @Param("type") Integer type
            , @Param("regionId") Long regionId);

}

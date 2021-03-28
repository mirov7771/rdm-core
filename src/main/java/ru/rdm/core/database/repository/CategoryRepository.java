package ru.rdm.core.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rdm.core.database.dao.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByParentIdAndTypeOrderByPriority(Long parentId, Integer type);
    List<Category> findByParentIdInAndTypeOrderByPriority(List<Long> parentIds, Integer type);

}

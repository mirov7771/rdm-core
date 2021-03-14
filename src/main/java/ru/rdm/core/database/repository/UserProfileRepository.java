package ru.rdm.core.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rdm.core.database.dao.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {

    UserProfile findByPhone(String phone);
    UserProfile findByUserId(Long userId);

}

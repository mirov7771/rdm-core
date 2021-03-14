package ru.rdm.core.database.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rdm.core.database.dao.UserSession;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface UserSessionRepository extends CrudRepository<UserSession, String> {

    UserSession findByAccessTokenAndExpiryAfter(String accessToken, Date expiry);
    UserSession findBySessionIdAndExpiryAfter(String sessionId, Date expiry);
    UserSession findBySessionIdAndCodeAndExpiryAfter(String sessionId, String code, Date expiry);
    @Transactional
    @Modifying
    @Query("delete from UserSession where phone = :phone")
    void deleteByPhone(@Param("phone") String phone);

}

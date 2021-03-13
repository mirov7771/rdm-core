package ru.rdm.core.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rdm.core.database.dao.UserSession;

import java.util.Date;

@Repository
public interface UserSessionRepository extends CrudRepository<UserSession, String> {

    UserSession findByAccessTokenAndExpiryAfter(String accessToken, Date expiry);
    UserSession findBySessionIdAndExpiryAfter(String sessionId, Date expiry);
    UserSession findBySessionIdAndCodeAndExpiryAfter(String sessionId, String code, Date expiry);

}

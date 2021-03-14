package ru.rdm.core.database.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rdm.core.database.dao.OtpCode;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface OtpCodeRepository extends CrudRepository<OtpCode, String> {

    OtpCode findByCodeAndPhoneAndTypeAndExpiryAfter(String code, String phone, String type, Date expiry);
    @Transactional
    @Modifying
    @Query("delete from OtpCode where phone = :phone and type = :type")
    void deleteByPhoneAndType(@Param("phone") String phone, @Param("type") String type);
}

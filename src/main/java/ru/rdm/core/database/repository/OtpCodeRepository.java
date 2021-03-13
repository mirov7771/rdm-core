package ru.rdm.core.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rdm.core.database.dao.OtpCode;

import java.util.Date;

@Repository
public interface OtpCodeRepository extends CrudRepository<OtpCode, String> {

    OtpCode findByCodeAndPhoneAndTypeAndExpiryAfter(String code, String phone, String type, Date expiry);

}

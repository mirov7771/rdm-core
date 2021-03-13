package ru.rdm.core.database.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "OTP_CODE")
@Data
public class OtpCode implements Serializable {

    private static final long serialVersionUID = 8903942274028585970L;

    @Id
    @Column(name = "CODE")
    private String code;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "EXPIRY")
    private Date expiry;

}

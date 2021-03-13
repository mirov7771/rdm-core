package ru.rdm.core.database.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USER_SESSION")
@Data
public class UserSession implements Serializable {

    private static final long serialVersionUID = 7862020336637303583L;

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "SESSIONID")
    private String sessionId;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "CODE")
    private String code;
    @Column(name = "ACCESSTOKEN")
    private String accessToken;
    @Column(name = "USERID")
    private Long userId;
    @Column(name = "EXPIRY")
    private Date expiry;

}

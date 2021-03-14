package ru.rdm.core.database.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USER_PROFILE")
@Data
public class UserProfile implements Serializable {

    private static final long serialVersionUID = -7123151956145685516L;

    @Id
    @Column(name = "USERID")
    private Long userId;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FIO")
    private String fio;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "INDATE")
    private Date indate;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "ASKED")
    private Boolean asked;

}

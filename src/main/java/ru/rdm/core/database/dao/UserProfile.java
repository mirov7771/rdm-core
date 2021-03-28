package ru.rdm.core.database.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rdm.core.controller.dto.support.Client;
import ru.rdm.core.enums.UserRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USER_PROFILE")
@NoArgsConstructor
@Data
public class UserProfile implements Serializable {

    private static final long serialVersionUID = -7123151956145685516L;

    @Id
    @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "LOCATIONID")
    private Long locationId;

    public UserProfile(String phone, Client client, UserRole role){
        this.phone = phone;
        this.email = client.getEmail();
        this.fio = client.getFio();
        this.location = client.getLocation();
        this.locationId = client.getLocationId();
        this.role = role.getRole();
        this.asked = false;
        this.indate = new Date();
    }

}

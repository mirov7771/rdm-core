package ru.rdm.core.database.dao;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "REGION_LINK")
@Data
public class RegionLink implements Serializable {

    private static final long serialVersionUID = 8647430888978116972L;

    @Id
    @Column(name = "LINKID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;
    @Column(name = "REGIONID")
    private Long regionId;
    @Column(name = "CHILDID")
    private Long childId;

}

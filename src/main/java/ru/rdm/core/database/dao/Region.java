package ru.rdm.core.database.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "REGION")
@Data
public class Region implements Serializable {

    private static final long serialVersionUID = 7491056113072981409L;

    @Id
    @Column(name = "REGIONID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;
    @Column(name = "REGIONNAME")
    private String regionName;

}

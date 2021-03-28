package ru.rdm.core.database.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORY")
@Data
public class Category implements Serializable {

    private static final long serialVersionUID = 6322025289494081807L;

    @Id
    @Column(name = "CATEGORYID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(name = "PARENTID")
    private Long parentId;
    @Column(name = "CATEGORYNAME")
    private String categoryName;
    @Column(name = "LOGOFILE")
    private String logoFile;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TYPE")
    private Integer type;
    @Column(name = "PRIORITY")
    private Integer priority;

}

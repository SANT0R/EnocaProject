package com.santor.enocaProject.model.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class BaseModel implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;


    @Column(unique = true, nullable = false)
    private String name ;


    @Column(nullable = false)
    private String phone ;


    @Column(nullable = false)
    private String eMail;

    @Column(nullable = false)
    private String address;

}

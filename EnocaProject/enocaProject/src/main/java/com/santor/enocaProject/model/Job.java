package com.santor.enocaProject.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Data
public class Job implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(nullable = false)
    private LocalDate startDate ;

    @Column(nullable = false)
    private LocalDate finishDate ;


    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Employee> employees = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Company> companies = new HashSet<>();




}

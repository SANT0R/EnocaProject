package com.santor.enocaProject.model;


import com.santor.enocaProject.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Table
@Entity
@Data
public class Employee extends BaseModel  {


    private static final long serialVersionUID = -7599045333722607430L;
    @Column( )
    private String lastName;

    @Column( )
    private String fullName = this.getName() +lastName;

    @Column( )
    private String jobTitle;

    @Column()
    private LocalDate hireDate;

    @Column( )
    private int salary;

    @ManyToOne ()
    private  Company company;

    @ManyToOne ()
    private  Job job;



}

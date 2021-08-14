package com.santor.enocaProject.model;

import com.santor.enocaProject.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseModel  {


    private static final long serialVersionUID = -6351021095604979392L;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();

    @ManyToMany(mappedBy = "companies", cascade = CascadeType.ALL)
    private Set<Job> jobs = new HashSet<>();

}

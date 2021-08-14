package com.santor.enocaProject.dto;

import com.santor.enocaProject.dto.base.BaseDTO;

import java.time.LocalDate;

public class EmployeeDTO  extends BaseDTO {

    private static final long serialVersionUID = -6266526934789306046L;

    private String lastName;

    private String fullName = this.getName() +lastName;

    private String jobTitle;

    private LocalDate hireDate;

    private int salary;

    private CompanyDTO companyDTO;

    private JobDTO jobDTO;


}

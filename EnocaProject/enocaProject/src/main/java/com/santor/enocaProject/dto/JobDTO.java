package com.santor.enocaProject.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class JobDTO {

    private static final long serialVersionUID = -6266526934789306046L;

    private Long id;

    private LocalDate startDate ;

    private LocalDate finishDate ;


    private Set<CompanyDTO> companyDTOS = new HashSet<>();

}

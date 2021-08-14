package com.santor.enocaProject.dto;

import com.santor.enocaProject.dto.base.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

public class CompanyDTO  extends BaseDTO {

    private static final long serialVersionUID = -6266526934789306046L;

    private Set<JobDTO> jobDTOS = new HashSet<>();
}

package com.santor.enocaProject.mapper;

import com.santor.enocaProject.dto.JobDTO;
import com.santor.enocaProject.model.Job;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring")
public interface JobMapper {

    @Named("toEntity")
    Job toEntity(JobDTO dto);

    @Named("toDTO")
    JobDTO toDTO(Job entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Job> toEntityList(List<JobDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDTO")
    List<JobDTO> toDTOList(List<Job> entityList);

}

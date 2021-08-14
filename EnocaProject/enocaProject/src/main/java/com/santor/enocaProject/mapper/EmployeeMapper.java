package com.santor.enocaProject.mapper;


import com.santor.enocaProject.dto.EmployeeDTO;
import com.santor.enocaProject.model.Employee;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Named("toEntity")
    Employee toEntity(EmployeeDTO dto);

    @Named("toDTO")
    EmployeeDTO toDTO(Employee entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Employee> toEntityList(List<EmployeeDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDTO")
    List<EmployeeDTO> toDTOList(List<Employee> entityList);

}

package com.santor.enocaProject.mapper;

import com.santor.enocaProject.dto.CompanyDTO;
import com.santor.enocaProject.model.Company;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Named("toEntity")
    Company toEntity(CompanyDTO dto);

    @Named("toDTO")
    CompanyDTO toDTO(Company entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Company> toEntityList(List<CompanyDTO> dtoList);

    @IterableMapping(qualifiedByName = "toDTO")
    List<CompanyDTO> toDTOList(List<Company> entityList);

}

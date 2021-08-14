package com.santor.enocaProject.service;


import com.santor.enocaProject.dao.CompanyRepo;
import com.santor.enocaProject.dto.CompanyDTO;
import com.santor.enocaProject.exception.ApiRequestException;
import com.santor.enocaProject.mapper.CompanyMapper;
import com.santor.enocaProject.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {


    @Autowired
    private CompanyRepo entityRepo;

    @Autowired
    private CompanyMapper entityMapper;


    @Override
    public void add(CompanyDTO company) {

        entityRepo.save(entityMapper.toEntity(company));

    }

    @Override
    public void update(CompanyDTO companyDTO) {

        Company entity = entityRepo.getById(companyDTO.getId());
        if (entity.getId() != null) {

            entityRepo.save(entityMapper.toEntity(companyDTO));

        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the author number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<CompanyDTO> getAll() {


        return entityMapper.toDTOList(entityRepo.findAll());
    }



    @Override
    public CompanyDTO getById(Long id) {

        Company entity = entityRepo.getOne(id);

        if (entity != null){

            return entityMapper.toDTO (entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the author number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<CompanyDTO> getByName(String fullName) {

        List<Company> companies = entityRepo.findByNameContains(fullName);

        return entityMapper.toDTOList (companies);

    }

    @Override
    public void deleteByName(String fullName) {

        Company entity = entityRepo.findByName(fullName);

        if (entity != null){

            entityRepo.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the author named " + fullName +" could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public void deleteAll() {

        entityRepo.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        Company entity = entityRepo.getOne(id);

        if (entity != null){

            entityRepo.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the author number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }


}

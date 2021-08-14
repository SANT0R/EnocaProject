package com.santor.enocaProject.service;

import com.santor.enocaProject.dao.EmployeeRepo;
import com.santor.enocaProject.dto.EmployeeDTO;
import com.santor.enocaProject.exception.ApiRequestException;
import com.santor.enocaProject.mapper.EmployeeMapper;
import com.santor.enocaProject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {



    @Autowired
    private EmployeeRepo entityRepo;

    @Autowired
    private EmployeeMapper entityMapper;


    @Override
    public void add(EmployeeDTO entity) {

        entityRepo.save(entityMapper.toEntity(entity));

    }

    @Override
    public void update(EmployeeDTO entityDTO) {

        Employee entity = entityRepo.getOne(entityDTO.getId());
        if (entity.getId() != null) {

            entityRepo.save(entityMapper.toEntity(entityDTO));

        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the author number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<EmployeeDTO> getAll() {


        return entityMapper.toDTOList(entityRepo.findAll());
    }



    @Override
    public EmployeeDTO getById(Long id) {

        Employee entity = entityRepo.getOne(id);

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
    public List<EmployeeDTO> getByName(String fullName) {

        List<Employee> entities = entityRepo.findByFullNameContains(fullName);

        return entityMapper.toDTOList (entities);

    }

    @Override
    public void deleteByName(String fullName) {

        Employee entity = entityRepo.findByFullName(fullName);

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

        Employee entity = entityRepo.getOne(id);

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

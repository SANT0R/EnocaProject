package com.santor.enocaProject.service;

import com.santor.enocaProject.dao.JobRepo;
import com.santor.enocaProject.dto.JobDTO;
import com.santor.enocaProject.exception.ApiRequestException;
import com.santor.enocaProject.mapper.JobMapper;
import com.santor.enocaProject.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl  implements JobService {

    @Autowired
    private JobRepo entityRepo;

    @Autowired
    private JobMapper entityMapper;


    @Override
    public void add(JobDTO entity) {

        entityRepo.save(entityMapper.toEntity(entity));

    }

    @Override
    public void update(JobDTO entityDTO) {

        Job entity = entityRepo.getOne(entityDTO.getId());
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
    public List<JobDTO> getAll() {


        return entityMapper.toDTOList(entityRepo.findAll());
    }



    @Override
    public JobDTO getById(Long id) {

        Job entity = entityRepo.getOne(id);

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
    public void deleteAll() {

        entityRepo.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        Job entity = entityRepo.getOne(id);

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

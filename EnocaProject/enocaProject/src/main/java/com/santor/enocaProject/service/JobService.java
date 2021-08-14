package com.santor.enocaProject.service;

import com.santor.enocaProject.dto.JobDTO;

import java.util.List;

public interface JobService {


    /**
     * Get all authors
     * @return List<JobDTO>
     */
    List<JobDTO> getAll();

    /**
     * Get a job by id
     * @param id -
     * @return JobDTO
     */
    JobDTO getById(Long id);


    /**
     * Delete all jobs
     */
    void deleteAll();

    /**
     * Delete a job by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Update a job
     * @param job -
     */
    void update(JobDTO job);

    /**
     * Add a job
     * @param job -
     */
    void add(JobDTO job);

}

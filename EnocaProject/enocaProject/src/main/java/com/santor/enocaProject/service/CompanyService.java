package com.santor.enocaProject.service;

import com.santor.enocaProject.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    /**
     * Get all jobs
     * @return List<JobDTO>
     */
    List<CompanyDTO> getAll();

    /**
     * Get a company by id
     * @param id -
     * @return CompanyDTO
     */
    CompanyDTO getById(Long id);

    /**
     * Get a company by full name
     * @param name -
     * @return List<CompanyDTO>
     */List<CompanyDTO> getByName(String name);

    /**
     * Delete all company's
     */
    void deleteAll();

    /**
     * Delete a company by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Delete a company by name
     * @param name -
     */
    void deleteByName(String name);

    /**
     * Update a company
     * @param company -
     */
    void update(CompanyDTO company);

    /**
     * Add a company
     * @param company -
     */
    void add(CompanyDTO company);

}

package com.santor.enocaProject.service;

import com.santor.enocaProject.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    /**
     * Get all employees
     * @return List<EmployeeDTO>
     */
    List<EmployeeDTO> getAll();

    /**
     * Get a employee by id
     * @param id -
     * @return EmployeeDTO
     */
    EmployeeDTO getById(Long id);

    /**
     * Get a employee by full name
     * @param name -
     * @return List<EmployeeDTO>
     */List<EmployeeDTO> getByName(String name);

    /**
     * Delete all employees
     */
    void deleteAll();

    /**
     * Delete a employee by id
     * @param id -
     */
    void deleteById(Long id);

    /**
     * Delete a employee by name
     * @param name -
     */
    void deleteByName(String name);

    /**
     * Update a employee
     * @param employee -
     */
    void update(EmployeeDTO employee);

    /**
     * Add a author
     * @param employee -
     */
    void add(EmployeeDTO employee);

}

package com.santor.enocaProject.dao;

import com.santor.enocaProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {


    Employee findByFullName(String fullName);

    List<Employee> findByFullNameContains(String fullName);

}

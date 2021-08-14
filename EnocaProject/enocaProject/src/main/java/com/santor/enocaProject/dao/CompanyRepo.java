package com.santor.enocaProject.dao;


import com.santor.enocaProject.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepo extends JpaRepository<Company, Long> {


    Company findByName(String name);

    List<Company> findByNameContains(String name);


}

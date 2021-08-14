package com.santor.enocaProject.dao;

import com.santor.enocaProject.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class CompanyRepoTest {


    @Autowired
    private CompanyRepo entityRepository ;

    Long firstId = 418L; //deleteById nin çalışması için DB deki en son kayıdın idsi verilmeli.

    private Company addEntity(String fullName){

        Company entity = new Company();
        entity.setName(fullName);

        entityRepository.save(entity);
        return entity;
    }


    @Test
    void addTest(){

        entityRepository.deleteAll();

        firstId++;

        addEntity("Mehmet Santor");


        Company entity = entityRepository.getOne(firstId);
        assertEquals(entity.getId(), firstId);

    }


    @Test
    void deleteByIdTest(){

        entityRepository.deleteAll();

        firstId++;

        addEntity("Mehmet Santor");


        entityRepository.deleteById(firstId);

        assertEquals(entityRepository.count(), 0);

    }

    @Test
    void deleteAllTest(){

        entityRepository.deleteAll();

        addEntity("Mehmet Santor");


        assertEquals(entityRepository.count(),1);
        entityRepository.deleteAll();


        assertEquals(entityRepository.count(), 0);

    }


    @Test
    void deleteByNameTest(){

        entityRepository.deleteAll();

        addEntity("Mehmet Santor");



        assertEquals(entityRepository.count(),1);

        entityRepository.delete(entityRepository.findByName("Mehmet Santor"));


        assertEquals(entityRepository.count(),0);


    }


    @Test
    void getByNameTest(){

        entityRepository.deleteAll();

        addEntity("Mehmet Santor");

        Company  entity = entityRepository.findByName("Mehmet Santor");

        assertEquals(entity.getName(),"Mehmet Santor" );

    }


    @Test
    void getByIdTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity("Mehmet Santor");
        Company entity = entityRepository.getOne(firstId);

        assertEquals(entity.getId(), firstId);

    }



    @Test
    void getAllTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity("Konyalı");

        addEntity("Urfalıyam Ezelden");

        addEntity("Ağrılı halo");

        addEntity("ya");


        assertEquals(entityRepository.count(), 4);

        Company entity1 = entityRepository.getOne(firstId);

        assertEquals(entity1.getId(), firstId);

        Company entity2 = entityRepository.getOne(firstId+1);

        assertEquals(entity2.getId(), firstId+1);

        Company entity3 = entityRepository.getOne(firstId+2);

        assertEquals(entity3.getId(), firstId+2);

        Company entity4 = entityRepository.getOne(firstId+3);

        assertEquals(entity4.getId(), firstId+3);
    }

    @Test
    void searchTest(){
        entityRepository.deleteAll();

        List<Company> expected = new ArrayList<>();
        expected.add(addEntity("Konyalı"));
        expected.add(addEntity("Urfalıyam Ezelden"));
        addEntity("Ağrılı halo");
        expected.add(addEntity("ya"));

        List<Company> actual = entityRepository.findByNameContains("ya");

        assertTrue(actual != null && actual.size() == 3);

        //assertEquals(expected,actual);
    }

}
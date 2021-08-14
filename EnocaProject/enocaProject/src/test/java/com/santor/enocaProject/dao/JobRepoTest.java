package com.santor.enocaProject.dao;

import com.santor.enocaProject.model.Job;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class JobRepoTest {



    @Autowired
    private JobRepo entityRepository ;

    Long firstId = 418L; //deleteById nin çalışması için DB deki en son kayıdın idsi verilmeli.

    private void addEntity(LocalDate date){

        Job entity = new Job();
        entity.setStartDate(date);

        entityRepository.save(entity);
    }


    @Test
    void addTest(){

        entityRepository.deleteAll();

        firstId++;

        addEntity(LocalDate.now());


        Job entity = entityRepository.getOne(firstId);
        assertEquals(entity.getId(), firstId);

    }


    @Test
    void deleteByIdTest(){

        entityRepository.deleteAll();

        firstId++;

        addEntity(LocalDate.now());


        entityRepository.deleteById(firstId);

        assertEquals(entityRepository.count(), 0);

    }

    @Test
    void deleteAllTest(){

        entityRepository.deleteAll();

        addEntity(LocalDate.now());


        assertEquals(entityRepository.count(),1);
        entityRepository.deleteAll();


        assertEquals(entityRepository.count(), 0);

    }


    @Test
    void getByIdTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity(LocalDate.now());
        Job entity = entityRepository.getOne(firstId);

        assertEquals(entity.getId(), firstId);

    }



    @Test
    void getAllTest() {

        entityRepository.deleteAll();

        firstId++;

        addEntity(LocalDate.now());

        addEntity(LocalDate.now());

        addEntity(LocalDate.now());

        addEntity(LocalDate.now());


        assertEquals(entityRepository.count(), 4);

        Job entity1 = entityRepository.getOne(firstId);

        assertEquals(entity1.getId(), firstId);

        Job entity2 = entityRepository.getOne(firstId+1);

        assertEquals(entity2.getId(), firstId+1);

        Job entity3 = entityRepository.getOne(firstId+2);

        assertEquals(entity3.getId(), firstId+2);

        Job entity4 = entityRepository.getOne(firstId+3);

        assertEquals(entity4.getId(), firstId+3);
    }

}
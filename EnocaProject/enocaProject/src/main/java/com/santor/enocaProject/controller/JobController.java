package com.santor.enocaProject.controller;

import com.santor.enocaProject.dto.JobDTO;
import com.santor.enocaProject.exception.ApiRequestException;
import com.santor.enocaProject.service.JobService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/job")
@CrossOrigin
public class JobController {


    @Autowired
    private JobService entityService;


    @ApiOperation(value = "Get all jobs")
    @GetMapping
    public ResponseEntity<List<JobDTO>> getAll()  {

        try {

            List<JobDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No job found.",
                        HttpStatus.NOT_FOUND);

            } else {
                return ResponseEntity.ok(entityDTOList);

            }

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Get a job by id")
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getById(@PathVariable Long id) {

        try {

            return ResponseEntity.ok(entityService.getById(id));

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @ApiOperation(value = "Delete all jobs")
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {

        try {

            List<JobDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No job found.",
                        HttpStatus.NOT_FOUND);

            } else {
                entityService.deleteAll();
                return ResponseEntity.ok().build();

            }

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Delete a job by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteById(@PathVariable Long id) {

        try {

            entityService.deleteById(id);
            return ResponseEntity.ok().build();

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Update a employee")
    @PutMapping
    public ResponseEntity<URI> update(@RequestBody JobDTO entity) {

        try {
            entityService.update(entity);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + entity.getId()).buildAndExpand(entity.getId()).toUri();

            return ResponseEntity.created(location).build();
        } catch (ServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @ApiOperation(value = "Add a job")
    @PostMapping
    public ResponseEntity<URI> add(@RequestBody JobDTO entity) {

        try {
            entityService.add(entity);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + entity.getId()).buildAndExpand(entity.getId()).toUri();

            return ResponseEntity.created(location).build();
        } catch (ServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

package com.devsuperior.hrworker.controllers;


import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = workerRepository.findAll();
        return ResponseEntity.ok().body(workers);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable final Long id) {
        var worker = workerRepository.findById(id).get();
        return ResponseEntity.ok().body(worker);
    }


}

package com.example.astonht2.works.controller;

import com.example.astonht2.works.model.Work;
import com.example.astonht2.works.service.WorkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/works/")
public class WorksController {
    private final WorkService service;

    public WorksController(WorkService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Work create(){
        return service.create();
    }
}

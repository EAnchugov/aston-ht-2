package com.example.astonht2.grades.model.controller;

import com.example.astonht2.grades.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade/")
public class GradeController {
    private final GradeService service;
    @Autowired
    public GradeController(GradeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Grade create(
            @RequestParam Long studentId,
            @RequestParam Long workId,
            @RequestParam Long grade
    ){
    return service.create(studentId,workId,grade);
    }

}

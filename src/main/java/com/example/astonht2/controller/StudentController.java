package com.example.astonht2.controller;

import com.example.astonht2.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(
            @RequestParam String name,
            @RequestParam String skype,
            @RequestParam String telegram,
            @RequestParam String github,
            @RequestParam Integer botScore) {
        return service.create(Student.builder()
                .name(name)
                .skype(skype)
                .telegram(telegram)
                .github(github)
                .botScore(botScore)
                .isActive(true)
                .build());
    }
}

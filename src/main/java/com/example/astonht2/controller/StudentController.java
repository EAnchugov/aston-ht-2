package com.example.astonht2.controller;

import com.example.astonht2.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(
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

    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);

    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAll() {
        return service.getAll();
    }

}

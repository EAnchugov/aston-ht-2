package com.example.astonht2.controller;

import com.example.astonht2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create(Student student) {
        return repository.save(student);
    }

    public Student update(Student student) {
        return repository.update(student);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}

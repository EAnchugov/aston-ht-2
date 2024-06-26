package com.example.astonht2.student.service;

import com.example.astonht2.student.model.Student;
import com.example.astonht2.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Student get(Long id) {
        return repository.get(id);
    }

    public List<Student> getAll() {
        return repository.getAll();
    }
}

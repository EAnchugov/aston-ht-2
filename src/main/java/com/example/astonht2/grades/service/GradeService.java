package com.example.astonht2.grades.service;

import com.example.astonht2.grades.model.Grade;
import com.example.astonht2.grades.repository.GradeRepository;
import com.example.astonht2.student.model.Student;
import com.example.astonht2.student.service.StudentService;
import com.example.astonht2.works.model.Work;
import com.example.astonht2.works.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    private final GradeRepository repository;
    private final StudentService studentService;
    private final WorkService workService;

    @Autowired
    public GradeService(GradeRepository repository, StudentService studentService, WorkService workService) {
        this.repository = repository;
        this.studentService = studentService;
        this.workService = workService;
    }

    public Grade create(Long studentId, Long workId, Long grade) {
        Student student = studentService.get(studentId);
        Work work = workService.getById(workId);

        return repository.create(Grade.builder().grade(grade).work(work).student(student).build());
    }
}

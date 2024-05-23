package com.example.astonht2.attendance.service;

import com.example.astonht2.attendance.model.Attendance;
import com.example.astonht2.attendance.repository.AttendanceRepository;
import com.example.astonht2.student.model.Student;
import com.example.astonht2.student.service.StudentService;
import com.example.astonht2.works.model.Work;
import com.example.astonht2.works.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AttendanceService {
    private final AttendanceRepository repository;
    private final StudentService studentService;
    private final WorkService workService;

    @Autowired
    public AttendanceService(AttendanceRepository repository, StudentService studentService, WorkService workService) {
        this.repository = repository;
        this.studentService = studentService;
        this.workService = workService;
    }


    public Attendance create(Long studentId, Long workId, String present) {
        Student student = studentService.get(studentId);
        Work work = workService.getById(workId);
        Attendance attendance = Attendance.builder()
                .student(student)
                .work(work)
                .present(present).
                build();
        return repository.create(attendance);
    }
}

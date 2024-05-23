package com.example.astonht2.attendance.controller;

import com.example.astonht2.attendance.model.Attendance;
import org.springframework.stereotype.Controller;

@Controller
public class AttendanceService {
    private final AttendanceRepository repository;

    public AttendanceService(AttendanceRepository repository) {
        this.repository = repository;
    }

    public Attendance create() {
        return repository.create();

    }
}

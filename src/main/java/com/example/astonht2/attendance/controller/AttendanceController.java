package com.example.astonht2.attendance.controller;

import com.example.astonht2.attendance.model.Attendance;
import com.example.astonht2.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance/")
public class AttendanceController {
    private final AttendanceService service;

    @Autowired
    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendance create(
            @RequestParam Long studentId,
            @RequestParam Long workId,
            @RequestParam String present
    ) {
        return service.create(studentId, workId, present);
    }
}

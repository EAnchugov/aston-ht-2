package com.example.astonht2.attendance.controller;

import com.example.astonht2.attendance.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance/")
public class AttendanceController {
    private AttendanceService service;

    @Autowired
    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendance create(){
        return service.create();
    }
}

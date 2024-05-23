package com.example.astonht2.attendance.controller;

import com.example.astonht2.attendance.model.Attendance;
import com.example.astonht2.student.model.Student;
import com.example.astonht2.utils.GlobalVariables;
import com.example.astonht2.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class AttendanceRepository {
    public Attendance create() {
//            Session session = HibernateSessionFactory.getSessionFactory().openSession();
//            Transaction tx1 = session.beginTransaction();
//            session.save(attendance);
//            tx1.commit();
//            session.close();
//            return attendance;
        return new Attendance();
    }
}

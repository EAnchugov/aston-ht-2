package com.example.astonht2.attendance.repository;

import com.example.astonht2.attendance.model.Attendance;
import com.example.astonht2.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceRepository {
    public Attendance create(Attendance attendance) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(attendance);
        tx1.commit();
        session.close();
        return attendance;

    }
}

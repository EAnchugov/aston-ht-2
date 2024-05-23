package com.example.astonht2.attendance.repository;

import com.example.astonht2.attendance.model.Attendance;
import com.example.astonht2.student.model.Student;
import com.example.astonht2.utils.HibernateSessionFactory;
import com.example.astonht2.works.model.Work;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceRepository {
    // TODO: 24.05.2024 убрать логику из репозитория
    public Attendance create(Student student, Work work, String present) {
        Attendance attendance = Attendance.builder()
                .student(student)
                .work(work)
                .present(present).
                build();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(attendance);
        tx1.commit();
        session.close();
        return attendance;

    }
}

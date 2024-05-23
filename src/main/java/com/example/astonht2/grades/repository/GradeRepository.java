package com.example.astonht2.grades.repository;

import com.example.astonht2.grades.model.Grade;
import com.example.astonht2.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class GradeRepository {
    public Grade create(Grade grade) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(grade);
        tx1.commit();
        session.close();
        return grade;
    }
}

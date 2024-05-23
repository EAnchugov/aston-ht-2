package com.example.astonht2.controller;

import com.example.astonht2.model.Student;
import com.example.astonht2.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.hibernate.cfg.Configuration;

@Repository
public class StudentRepository {

    public Student save(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
        return student;
    }

    public Student update(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
        return student;
    }

    public void delete(Long id) {
        Student student;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        student = session.load(Student.class,id);
        session.delete(student);
        tx1.commit();
        session.close();
    }
}

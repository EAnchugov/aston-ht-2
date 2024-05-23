package com.example.astonht2.utils;

import com.example.astonht2.attendance.model.Attendance;
import com.example.astonht2.grades.model.Grade;
import com.example.astonht2.student.model.Student;
import com.example.astonht2.works.model.Work;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Attendance.class);
                configuration.addAnnotatedClass(Work.class);
                configuration.addAnnotatedClass(Grade.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                throw new HibernateException("Ошибка при создании SessionFactory", e);
            }
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
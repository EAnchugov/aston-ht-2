package com.example.astonht2.works.repositry;

import com.example.astonht2.utils.HibernateSessionFactory;
import com.example.astonht2.works.model.Work;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WorkRepository {
    public Work create() {
        Work work = Work.builder().date(LocalDate.now()).build();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(work);
        tx1.commit();
        session.close();
        return work;
    }

    public Work getById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Work.class, id);
    }
}

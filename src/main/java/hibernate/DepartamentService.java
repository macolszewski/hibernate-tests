package hibernate;

import hibernate.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class DepartamentService {

    private final SessionFactory sessionFactory;

    DepartamentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addDepartament(Departament departament) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(departament);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getDepartaments() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List books = session.createQuery("FROM Departament").list();
            for (Iterator iterator = books.iterator(); iterator.hasNext(); ) {
                Departament departament = (Departament) iterator.next();
                System.out.println(departament.toString());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}

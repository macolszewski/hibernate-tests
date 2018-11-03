package hibernate;

import hibernate.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class ProjectService {

    private final SessionFactory sessionFactory;

    ProjectService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(project);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getProjects() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List books = session.createQuery("FROM Project").list();
            for (Iterator iterator = books.iterator(); iterator.hasNext(); ) {
                Project project = (Project) iterator.next();
                System.out.println(project.toString());
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

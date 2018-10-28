package hibernate;

import hibernate.model.Author;
import hibernate.model.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AuthorService {

    private final SessionFactory sessionFactory;

    AuthorService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAuthor(Author author) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(author);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}

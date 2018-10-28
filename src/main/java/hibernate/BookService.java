package hibernate;

import hibernate.model.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookService {

    private final SessionFactory sessionFactory;

    BookService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(book);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void getBooks() {

    }
}

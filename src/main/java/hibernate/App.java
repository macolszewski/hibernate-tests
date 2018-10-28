package hibernate;

import hibernate.model.Author;
import hibernate.model.Book;
import hibernate.model.Human;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args ) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Book book = new Book("Koń Rafał","1923","Bajka");
//        Book book2 = new Book("Koń Rafał II","1925","Bajka");
        BookService bookService = new BookService(sessionFactory);
//        bookService.addBook(book);
//        bookService.addBook(book2);
//
//        Author author = new Author(new Human("Andrzej","Lęgarek"),
//                "Bajka","Lęgar"," ");
//        Author author2 = new Author(new Human("Robert","Roger"),
//                "Thriller"," "," ");
//
        AuthorService authorService = new AuthorService(sessionFactory);
//        authorService.addAuthor(author);
//        authorService.addAuthor(author2);

        bookService.getBooks();
        authorService.getAuthors();

        bookService.updateBook("ff80818166baf7340166baf736a90000","Zły tytuł");

        sessionFactory.close();

    }
}

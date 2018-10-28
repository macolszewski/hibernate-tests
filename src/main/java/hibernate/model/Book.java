package hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "book_new")
@AttributeOverride(name = "id", column = @Column(name="book_id"))
public class Book extends BaseEntitiy {

    @Column(name="book_title")
    private String title;

    @Column(name="year_of_release")
    private String yearOfRelease;

    @Column(name="book_type")
    private String bookType;

    public Book() {
    }

    public Book(String title, String yearOfRelease, String bookType) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.bookType = bookType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", bookType='" + bookType + '\'' +
                "} " + super.toString();
    }
}

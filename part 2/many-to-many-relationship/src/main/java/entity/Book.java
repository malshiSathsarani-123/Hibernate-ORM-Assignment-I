package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Book {
    @Id
    private String bookId;
    private String bookName;
    private Double price;

    @ManyToMany
    private List<Author>authors;

    public Book() {
    }

    public Book(String bookId, String bookName, Double price, List<Author> authors) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.authors = authors;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", authors=" + authors +
                '}';
    }
}

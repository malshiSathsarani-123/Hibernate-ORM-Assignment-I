import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book();
        book1.setBookId("B001");
        book1.setBookName("Nature");
        book1.setPrice(1000.00);

        Book book2 = new Book();
        book2.setBookId("B002");
        book2.setBookName("One_Piece");
        book2.setPrice(1500.00);

        Author author1 = new Author();
        author1.setId("A001");
        author1.setName("Mr.MartienWickramasingha");
        author1.setCountry("SriLanka");

        List<Book> books1 = new ArrayList<>();
        books1.add(book1);
        books1.add(book2);

        author1.setBooks(books1);
        book1.setAuthor(author1);
        book2.setAuthor(author1);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book1);
        session.persist(book2);
        session.persist(author1);
        transaction.commit();
        session.close();
    }
}

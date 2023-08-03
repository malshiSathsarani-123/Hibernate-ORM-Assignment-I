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

        Author author2 = new Author();
        author2.setId("A002");
        author2.setName("Mr.Dao");
        author2.setCountry("Japan");

        List<Book> books=new ArrayList<>();
        books.add(book1);
        books.add(book2);

        List<Author>authors= new ArrayList<>();
        authors.add(author1);
        authors.add(author1);

        book1.setAuthors(authors);
        book2.setAuthors(authors);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(author1);
        session.persist(author2);
        session.persist(book1);
        session.persist(book2);
        transaction.commit();
        session.close();
    }
}

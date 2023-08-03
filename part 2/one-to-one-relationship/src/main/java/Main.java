import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.FactoryConfiguration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mainMethod();
    }

    static Scanner scanner = new Scanner(System.in);
    static Book book = new Book();
    static Author author = new Author();


    public static void mainMethod() {

        System.out.println("01 ADD BOOK\t\t\t02 DELETE BOOK");
        System.out.println("03 UPDATE BOOK\t\t\t04 SEARCH BOOK");
        System.out.println("");

        System.out.print("Enter option : ");
        int option = scanner.nextInt();

        switch (option){
            case 1:save();
            case 2:delete();
            case 3:update();
            case 4:search();
        }
    }
    public static void save(){

        L: do {

            System.out.print("Input book id : ");
            book.setBookId(scanner.next());

            System.out.print("Input book name : ");
            book.setBookName(scanner.next());

            System.out.print("Input book price : ");
            book.setPrice(scanner.nextDouble());


            System.out.print("Input author id : ");
            author.setId(scanner.next());

            System.out.print("Input author name : ");
            author.setName(scanner.next());

            System.out.print("Input author country : ");
            author.setCountry(scanner.next());

            book.setAuthor(author);

            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(book);
            session.persist(author);
            transaction.commit();
            session.close();

            System.out.println("");
            System.out.println("");
            System.out.println("01:DO YOU WANT TO BACK MENU\t\t\t02:SAVE BOOK");
            System.out.println("");
            System.out.print("Enter option : ");
            int option = scanner.nextInt();

            switch (option){
                case 1 : mainMethod();
                case 2: continue L;
            }
        }while (true);
    }

    public static void delete(){

        L: do {
            System.out.print("Input want book id : ");
            book.setBookId(scanner.next());

            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.remove(book);
            transaction.commit();
            session.close();

            System.out.println("");
            System.out.println("");
            System.out.println("01:DO YOU WANT TO BACK MENU\t\t\t02:DELETE BOOK");
            System.out.println("");
            System.out.print("Enter option : ");
            int option = scanner.nextInt();

            switch (option){
                case 1 : mainMethod();
                case 2: continue L;
            }
        }while (true);
    }

    public static void update(){

        L: do {

            System.out.print("Input book id : ");
            String id = scanner.next();
            book.setBookId(id);

            String aId = search1(id);
            author.setId(aId);

            System.out.print("update book name : ");
            book.setBookName(scanner.next());

            System.out.print("update book price : ");
            book.setPrice(scanner.nextDouble());

            System.out.print("update author name : ");
            author.setName(scanner.next());

            System.out.print("update author country : ");
            author.setCountry(scanner.next());

            book.setAuthor(author);

            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(book);
            session.update(author);
            transaction.commit();
            session.close();

            System.out.println("");
            System.out.println("");
            System.out.println("01:DO YOU WANT TO BACK MENU\t\t\t02:SAVE BOOK");
            System.out.println("");
            System.out.print("Enter option : ");
            int option = scanner.nextInt();

            switch (option){
                case 1 : mainMethod();
                case 2: continue L;
            }
        }while (true);
    }

    public static String search1(String id){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        book = session.get(Book.class,id);
        System.out.println(book.getBookId()+"  "+book.getBookName()+"  "+book.getPrice()+"  "+book.getAuthor());
        transaction.commit();
        session.close();

        return book.getAuthor().getId();
    }
    public static void search(){
        L: do {

            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            System.out.print("Input want book id : ");
            book = session.get(Book.class,scanner.next());
            System.out.println(book.getBookId()+"  "+book.getBookName()+"  "+book.getPrice()+"  "+book.getAuthor());
            transaction.commit();
            session.close();


            System.out.println("");
            System.out.println("");
            System.out.println("01:DO YOU WANT TO BACK MENU\t\t\t02:SEARCH BOOK");
            System.out.println("");
            System.out.print("Enter option : ");
            int option = scanner.nextInt();

            switch (option){
                case 1 : mainMethod();
                case 2: continue L;
            }
        }while (true);
    }

}

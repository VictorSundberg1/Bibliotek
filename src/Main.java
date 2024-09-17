
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("Harry Potter: Philosopher's Stone", "J.K Rowling", "1997", "1st");
        Book b2 = new Book("Harry Potter: Chamber of Secrets", "J.K Rowling", "1998", "1st");

        ArrayList<Book> books = new ArrayList<>();
        
        books.add(b1);
        books.add(b2);

        for (Book book : books){
            System.out.println(book);
        }
        b1.returnBook();
        b1.loanBook();
        b1.loanBook();
        b1.returnBook();
        b1.returnBook();

    }
}
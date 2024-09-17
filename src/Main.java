
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        Book b1 = new Book("Harry Potter: Philosopher's Stone", "J.K Rowling", "1997", "1st");
        Book b2 = new Book("Harry Potter: Chamber of Secrets", "J.K Rowling", "1998", "1st");
        ArrayList<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);


        while (running){
            printMenu();
            int menuChoice = sc.nextInt();
            switch (menuChoice){
                case 1:

                    break;
                case 2:
                    System.out.println("Enter name of book: ");
                    Scanner sc2 = new Scanner(System.in);
                    String input = sc2.next();
                    for (Book bookloop : books) {

                    }

                case 3:
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;

            }


        }





    }

    public static void printMenu(){
        System.out.println("1. Add a book to the library");
        System.out.println("2. Search for a book by name");
        System.out.println("3. List all available books");
        System.out.println("4. Return a book");
        System.out.println("5. Quit");

    }
}
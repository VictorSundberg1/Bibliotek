
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
                    newBook(books);
                    break;
                case 2:
                    for (Book bookloop : books) {

                    }

                    break;
                case 3:
                    int counter = 0;

                    for (Book book : books) {
                        if (book.isAvailability()){
                            counter++;
                            System.out.println(counter + " " + book);
                        }
                    }
                    break;
                case 4:


                    break;
                case 5:


                    break;
            }
        }
    }

    public static void newBook(ArrayList<Book> books){
        String bookName, author;
        String bookYear, bookEdition;

        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Add a book");
        System.out.println("Title: ");
        bookName = input.nextLine();
        System.out.println("Author: ");
        author = input.nextLine();
        System.out.println("Year of release: ");
        bookYear = input.next();
        input.nextLine();
        System.out.println("Edition: ");
        bookEdition = input.next();

        books.add(new Book(bookName, author, bookYear, bookEdition));
        System.out.println("Book has been added!");

    }

    public static void printMenu(){
        System.out.println("1. Add a book to the library");
        System.out.println("2. Search for a book by name");
        System.out.println("3. List all available books");
        System.out.println("4. Return a book");
        System.out.println("5. Quit");

    }
}
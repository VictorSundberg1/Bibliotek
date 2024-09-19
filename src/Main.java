
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        Scanner sc = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Stjärnfall", "Elin Andersson", "2021", "1st"));
        books.add(new Book("Havets sång", "Magnus Lindström", "2019", "1st"));
        books.add(new Book("Dolda skatter", "Sara Pettersson", "2020", "1st"));
        books.add(new Book("Skuggornas rike", "Anders Björk", "2022", "1st"));
        books.add(new Book("Tidens vägar", "Karin Nilsson", "2018", "1st"));
        books.add(new Book("Vinterdröm", "Johan Eriksson", "2023", "1st"));
        books.add(new Book("Eldens hjärta", "Fredrik Svensson", "2021", "1st"));
        books.add(new Book("Månskensnätter", "Sofia Bergström", "2018", "1st"));
        books.add(new Book("Över havet", "Eva Lind", "2019", "1st"));
        books.add(new Book("Drömmar av guld", "Jonas Eriksson", "2021", "1st"));


        while (running){
            printMenu();
            int menuChoice = sc.nextInt();
            switch (menuChoice){
                case 1:
                    newBook(books);
                    break;
                case 2:
                    searchBook(books);
                    break;
                case 3:
                    checkLibrary(books);
                    break;
                case 4:
                    returnBook(books);
                    break;
                case 5:
                    checkLoanedBooks(books);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
            }
        }
    }


    //Checking for books that have been loaned out
    public static void checkLoanedBooks(ArrayList<Book> books){
        int counter2 = 0;
        System.out.println("The books that are currently loaned out are: ");
        for (Book book : books) {
            if (!book.isAvailability()){
                counter2++;
                System.out.println(counter2 + " " + book);
                System.out.println();
            }
        }
        if (counter2 < 1){
            System.out.println("No books currently loaned out!");
        }
    }

    //Checking for available books
    public static void checkLibrary(ArrayList<Book> books){
        System.out.println("The books that are available are: ");
        int counter = 0;
        for (Book book : books) {
            if (book.isAvailability()){
                counter++;
                System.out.println(counter + " " + book);
                System.out.println();
            }
        }
        if (counter < 1){
            System.out.println("No books currently available!");
        }
    }

    //Return books
    public static void returnBook(ArrayList<Book> books){
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter title of the book you want to return!");
        String returnChoice = sc3.nextLine();

        for (Book book : books){
            if (book.getBookName().equalsIgnoreCase(returnChoice)){
                System.out.println(book);
                if (!book.isAvailability()){
                    System.out.println("Do you want to return this book? Y/N");
                    if (sc3.next().equalsIgnoreCase("Y")){
                        book.returnBook();
                        System.out.println();
                        System.out.println(book + " Has been returned!");
                    } else {
                        System.out.println("No book has been returned");
                    }
                }
                else if (book.isAvailability()) {
                    System.out.println("This book already exists in the library");
                }
            }
        }

    }

    //Search and loan books
    public static void searchBook(ArrayList<Book> books){
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Entre title of the book");
        String loanChoice = sc2.nextLine();
        boolean bookFound = false;

        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(loanChoice)) {
                bookFound = true;
                System.out.println(book);

                if (book.isAvailability()) {
                    System.out.println("Do you want to loan this book? Y/N");
                    if (sc2.next().equalsIgnoreCase("Y")) {
                        book.loanBook();
                        System.out.println();
                        System.out.println(book + " Has been loaned out");
                    } else {
                        System.out.println("No book loaned");
                    }
                }
                else{
                    System.out.println("Book is unavailable");
                }
            }
        }
        if (!bookFound){
            System.out.println("No book with that title was found!");
        }
    }

    //Add new books to the arraylist
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
        System.out.println("Year of the book release: ");
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
        System.out.println("5. List all currently loaned out books");
        System.out.println("6. Quit");

    }
}
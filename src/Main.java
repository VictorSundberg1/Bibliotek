
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        Scanner sc = new Scanner(System.in);

        Book b1 = new Book("Stjärnfall", "Elin Andersson", "2021", "1st");
        Book b2 = new Book("Havets sång", "Magnus Lindström", "2019", "1st");
        Book b3 = new Book("Dolda skatter", "Sara Pettersson", "2020", "1st");
        Book b4 = new Book("Skuggornas rike", "Anders Björk", "2022", "1st");
        Book b5 = new Book("Tidens vägar", "Karin Nilsson", "2018", "1st");
        Book b6 = new Book("Vinterdröm", "Johan Eriksson", "2023", "1st");
        Book b7 = new Book("Eldens hjärta", "Fredrik Svensson", "2021", "1st");
        Book b8 = new Book("Månskensnätter", "Sofia Bergström", "2018", "1st");
        Book b9 = new Book("Över havet", "Eva Lind", "2019", "1st");
        Book b10 = new Book("Drömmar av guld", "Jonas Eriksson", "2021", "1st");

        ArrayList<Book> books = new ArrayList<>();

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);
        books.add(b9);
        books.add(b10);


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
                    int counter = 0;
                    for (Book book : books) {
                        if (book.isAvailability()){
                            counter++;
                            System.out.println(counter + " " + book);
                            System.out.println();
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

    //Search and loan book function
    public static void searchBook(ArrayList<Book> books){
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Entre title of the book");
        String loanChoice = sc2.nextLine();
        boolean bookFound = false;

        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(loanChoice)) {
                bookFound = true;
                System.out.println(book.toString());

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

    //Add book function
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
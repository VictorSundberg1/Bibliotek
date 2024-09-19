public class Book {
    private String bookName;
    private String author;
    private String bookYear;
    private String bookEdition;
    private boolean availability = true;

    public Book(String bookName, String author, String bookYear, String bookEdition) {
        this.bookName = bookName;
        this.author = author;
        this.bookYear = bookYear;
        this.bookEdition = bookEdition;

    }



    public void loanBook() {
        if (availability){
            availability = false;
            System.out.println( "You have loaned " + bookName);
        }else {
            System.out.println("The book is unavailable");
        }
    }

    public void returnBook() {
        if (!availability){
            availability = true;
            System.out.println( "You have returned " + bookName);
        }else {
            System.out.println("The book is already available");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", bookYear='" + bookYear + '\'' +
                ", bookEdition='" + bookEdition + '\'' +
                ", availability=" + availability +
                '}';
    }


    //GETTERS AND SETTERS
    public String getBookName() {
        return bookName;
    }

    public boolean isAvailability() {
        return availability;
    }

}

public class Book {
    String bookName;
    String author;
    String bookYear;
    String bookEdition;
    boolean availability = true;

    public Book(String bookName, String author, String bookYear, String bookEdition) {
        this.bookName = bookName;
        this.author = author;
        this.bookYear = bookYear;
        this.bookEdition = bookEdition;

    }



    public void loanBook() {
        if (availability == true){
            availability = false;
            System.out.println( "You have loaned " + bookName);
        }else {
            System.out.println("The book is unavailable");
        }
    }

    public void returnBook() {
        if (availability == false){
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}

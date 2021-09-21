package com.solid.principles;

/*
    One class should only have one responsibility
*/
public class SingleResponsibility {
    public static void main(String[] args) {
        Book book = new Book("Harry Potter", "JK Rowling");
        BookPrinter bookPrinter = new BookPrinter(book);
        bookPrinter.printBookToConsole();
    }
}

class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    /*
        public void printToConsole() {
            // violates Single Responsibility principle

            (create another class BookPrinter which will use Book class toString method to print)
        }
    */


}

class BookPrinter {

    private Book book;

    public BookPrinter(Book book) {
        this.book = book;
    }

    public void printBookToConsole() {
        System.out.println(book.toString());
    }
}

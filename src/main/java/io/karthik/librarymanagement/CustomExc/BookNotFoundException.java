package io.karthik.librarymanagement.CustomExc;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Book Id: " + id + ", not found!!");
    }
}

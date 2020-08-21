package io.karthik.librarymanagement.CustomExc;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("User Id: " + id + ", not found!!");
    }
}

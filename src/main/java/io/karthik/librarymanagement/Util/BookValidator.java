package io.karthik.librarymanagement.Util;

import io.karthik.librarymanagement.Models.Books;

public class BookValidator {
    public boolean isValid(Books book){

        if(book.getTitle()=="" || book.getTitle().equals(null))
            return false;
        return true;
    }
}

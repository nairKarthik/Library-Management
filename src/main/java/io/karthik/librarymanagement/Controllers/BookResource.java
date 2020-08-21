package io.karthik.librarymanagement.Controllers;

import io.karthik.librarymanagement.CustomExc.BookNotFoundException;
import io.karthik.librarymanagement.Models.Books;
import io.karthik.librarymanagement.Repositories.BookRepository;
import io.karthik.librarymanagement.Util.BookValidator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class BookResource {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    BookRepository bookRepository;

    BookValidator validator = new BookValidator();

    @ApiOperation(value = "Lists all books!!")
    @GetMapping("/books")
    public List<Books> findAll() {
        LOGGER.info("findAll called!!");
        List<Books> list = new ArrayList<>();
        try {
            list = bookRepository.findAll();
            if(list.size() == 0) {
                LOGGER.severe("No books were found");
                throw new BookNotFoundException(5);
            }
        } catch (BookNotFoundException e) {
            LOGGER.severe(e.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No books found!!", e);
        }
        return list;
    }

    @PostMapping("/books")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Books newBook(@RequestBody Books newBook) {

        if (validator.isValid(newBook))
            return bookRepository.save(newBook);
        else {
            LOGGER.severe("newBook is not valid");
            return null;
        }
    }

    @GetMapping(value = "/searchBooksByAuthor")
    public List<Books> searchBooksByAuthor(@RequestParam(value = "q") String author){
        List<Books> books = bookRepository.findAll();
        ArrayList<Books> list = new ArrayList<Books>();
        for(Books book : books){
            if(book.getAuthor_f_name().equals(author)) list.add(book);
        }
        return list;
    }

    @GetMapping(value = "/searchBooksBySubject")
    public List<Books> searchBooksBySubject(@RequestParam(value = "q") String subject){
        List<Books> books = bookRepository.findAll();
        ArrayList<Books> list = new ArrayList<Books>();
        for(Books book : books){
            if(book.getSubject().equals(subject)) list.add(book);
        }
        return list;
    }
}

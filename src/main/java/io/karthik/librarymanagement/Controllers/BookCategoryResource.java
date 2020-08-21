package io.karthik.librarymanagement.Controllers;

import io.karthik.librarymanagement.Models.BookCategories;
import io.karthik.librarymanagement.Repositories.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class BookCategoryResource {
    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    BookCategoryRepository cat;

    @GetMapping("/category")
    public List<BookCategories> findAll() {
        LOGGER.info("findAll Called!");
        List<BookCategories> list = new ArrayList<>();
        try {
            list = cat.findAll();
            if (list.size() == 0) {
                LOGGER.severe("No category were found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewCategory(@RequestBody BookCategories bc) {
        cat.save(bc);
    }

    @GetMapping("/category/{name}")
    public BookCategories findCategoriesById(@PathVariable String name) {
        return cat.findBookCategoryByName(name);
    }
}

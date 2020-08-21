package io.karthik.librarymanagement.Repositories;

import io.karthik.librarymanagement.Models.BookCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookCategoryRepository extends JpaRepository<BookCategories, Integer> {
    @Query(value = "SELECT bc FROM BookCategories bc WHERE bc.catName=:catName")
    public BookCategories findBookCategoryByName(String catName);
}

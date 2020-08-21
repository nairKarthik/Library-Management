package io.karthik.librarymanagement.Repositories;

import io.karthik.librarymanagement.Models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {

}

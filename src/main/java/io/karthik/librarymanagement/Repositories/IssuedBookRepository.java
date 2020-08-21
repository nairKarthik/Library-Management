package io.karthik.librarymanagement.Repositories;

import io.karthik.librarymanagement.Models.IssuedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBookRepository extends JpaRepository<IssuedBooks, Integer> {
}

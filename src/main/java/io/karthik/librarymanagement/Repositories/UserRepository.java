package io.karthik.librarymanagement.Repositories;

import io.karthik.librarymanagement.Models.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
}

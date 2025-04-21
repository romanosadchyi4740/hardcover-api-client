package com.coursework.bookstore_graphql_client.repository;

import com.coursework.bookstore_graphql_client.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}

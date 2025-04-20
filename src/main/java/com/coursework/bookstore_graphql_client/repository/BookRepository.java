package com.coursework.bookstore_graphql_client.repository;

import com.coursework.bookstore_graphql_client.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

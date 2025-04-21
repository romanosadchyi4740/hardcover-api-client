package com.coursework.bookstore_graphql_client.repository;

import com.coursework.bookstore_graphql_client.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByGenreName(String genreName);
}

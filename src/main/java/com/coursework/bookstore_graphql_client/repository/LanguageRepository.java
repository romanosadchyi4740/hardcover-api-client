package com.coursework.bookstore_graphql_client.repository;

import com.coursework.bookstore_graphql_client.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}

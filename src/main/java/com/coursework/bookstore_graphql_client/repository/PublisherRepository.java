package com.coursework.bookstore_graphql_client.repository;

import com.coursework.bookstore_graphql_client.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}

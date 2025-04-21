package com.coursework.bookstore_graphql_client.service;

import com.coursework.bookstore_graphql_client.dto.BookDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface BookService {
    List<BookDto> getBooks();

    @Transactional
    void saveBooks(List<BookDto> bookDtos);
}

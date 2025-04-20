package com.coursework.bookstore_graphql_client.service;

import com.coursework.bookstore_graphql_client.client.BookstoreClient;
import com.coursework.bookstore_graphql_client.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookstoreClient bookstoreClient;

    @Autowired
    public BookService(BookstoreClient bookstoreClient) {
        this.bookstoreClient = bookstoreClient;
    }

    public List<BookDto> getBooks() {
        return bookstoreClient.getBooks();
    }

    public void saveBooks() {

    }

}

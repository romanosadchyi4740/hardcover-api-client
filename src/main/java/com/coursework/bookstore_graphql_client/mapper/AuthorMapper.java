package com.coursework.bookstore_graphql_client.mapper;

import com.coursework.bookstore_graphql_client.dto.BookDto;
import com.coursework.bookstore_graphql_client.model.Author;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorMapper {

    public static Author toModel(BookDto.BookContributionsDto.BookAuthorDto bookAuthorDto) {
        return new Author(bookAuthorDto.getId(), bookAuthorDto.getName());
    }

}

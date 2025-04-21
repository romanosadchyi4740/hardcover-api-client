package com.coursework.bookstore_graphql_client.mapper;

import com.coursework.bookstore_graphql_client.dto.BookDto;
import com.coursework.bookstore_graphql_client.model.Book;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookMapper {

    public static Book toModel(BookDto bookDto) {
        Book result = new Book();
        result.setId(bookDto.getId());
        result.setTitle(bookDto.getTitle());
        result.setPrice(bookDto.getPrice());
        result.setNumberInStock(bookDto.getNumberInStock());
        return result;
    }

}

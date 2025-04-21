package com.coursework.bookstore_graphql_client.mapper;

import com.coursework.bookstore_graphql_client.dto.BookDto;
import com.coursework.bookstore_graphql_client.model.Genre;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GenreMapper {

    public static Genre toModel(BookDto.GenreDto genreDto) {
        Genre result = new Genre();
        result.setGenreName(genreDto.getTag());
        return result;
    }

}

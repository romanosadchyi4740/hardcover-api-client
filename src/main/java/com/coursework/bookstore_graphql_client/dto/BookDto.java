package com.coursework.bookstore_graphql_client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private BookImageDto image;
    private List<BookContributionsDto> contributions = new ArrayList<>();
    private double price = Math.round(Math.random() * 100 + 50);
    private int numberInStock = (int) Math.round(Math.random() * 100);
    private int languageId = (int) Math.ceil(Math.random() * 185);
    private List<GenreDto> cached_tags = new ArrayList<>();
    private int publisherId = (int) (Math.random() < 0.5 ? Math.ceil(Math.random() * 9) :
            58 + Math.ceil(Math.random() * 88));

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BookImageDto {
        private String url;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GenreDto {
        private String tag;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BookContributionsDto {
        private BookAuthorDto author;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class BookAuthorDto {
            private int id;
            private String name;
        }
    }

}

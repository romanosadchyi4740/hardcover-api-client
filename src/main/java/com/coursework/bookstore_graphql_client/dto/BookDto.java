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
    private List<BookContributionsDto> contributions = new ArrayList<>();
    private double price = Math.round(Math.random() * 100 + 50);
    private int numberInStock = (int) Math.round(Math.random() * 100);
    private String language;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BookContributionsDto {
        private BookAuthorDto author;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class BookAuthorDto {
            private String name;
        }
    }

}

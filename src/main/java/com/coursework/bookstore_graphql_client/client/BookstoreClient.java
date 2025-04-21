package com.coursework.bookstore_graphql_client.client;

import com.coursework.bookstore_graphql_client.dto.BookDto;
import com.coursework.bookstore_graphql_client.dto.LanguageDto;
import com.coursework.bookstore_graphql_client.dto.PublisherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookstoreClient {

    private final HttpGraphQlClient httpGraphQlClient;

    @Autowired
    public BookstoreClient(HttpGraphQlClient httpGraphQlClient) {
        this.httpGraphQlClient = httpGraphQlClient;
    }

    public List<BookDto> getBooks() {
        String graphQLQuery = """
                query Books {
                     books {
                         id
                         title
                         contributions {
                             author {
                                 id
                                 name
                             }
                         }
                         cached_tags(path: "Genre")
                     }
                 }""";

        return httpGraphQlClient.document(graphQLQuery)
                .retrieve("books")
                .toEntityList(BookDto.class).block();
    }

    public List<LanguageDto> getLanguages() {
        String graphQLQuery = """
                query Languages {
                    languages {
                        id
                        language
                    }
                }""";

        return httpGraphQlClient.document(graphQLQuery)
                .retrieve("languages")
                .toEntityList(LanguageDto.class).block();
    }

    public List<PublisherDto> getPublishers() {
        String graphQLQuery = """
                query Publishers {
                    publishers(where: {id: { _lt: 200 } }) {
                        id
                        name
                    }
                }""";

        return httpGraphQlClient.document(graphQLQuery)
                .retrieve("publishers")
                .toEntityList(PublisherDto.class).block();
    }

}

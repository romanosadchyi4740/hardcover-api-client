package com.coursework.bookstore_graphql_client.service;

import com.coursework.bookstore_graphql_client.client.BookstoreClient;
import com.coursework.bookstore_graphql_client.dto.BookDto;
import com.coursework.bookstore_graphql_client.mapper.AuthorMapper;
import com.coursework.bookstore_graphql_client.mapper.BookMapper;
import com.coursework.bookstore_graphql_client.mapper.GenreMapper;
import com.coursework.bookstore_graphql_client.model.Author;
import com.coursework.bookstore_graphql_client.model.Book;
import com.coursework.bookstore_graphql_client.model.Genre;
import com.coursework.bookstore_graphql_client.repository.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final LanguageRepository languageRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final PublisherRepository publisherRepository;
    private final BookstoreClient bookstoreClient;

    @Autowired
    public BookService(BookRepository bookRepository,
                       LanguageRepository languageRepository,
                       AuthorRepository authorRepository,
                       GenreRepository genreRepository,
                       PublisherRepository publisherRepository,
                       BookstoreClient bookstoreClient) {
        this.bookRepository = bookRepository;
        this.languageRepository = languageRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.publisherRepository = publisherRepository;
        this.bookstoreClient = bookstoreClient;
    }

    public List<BookDto> getBooks() {
        return bookstoreClient.getBooks();
    }

    @Transactional
    public void saveBooks(List<BookDto> bookDtos) {
        bookDtos.forEach(bookDto -> {
            Book book = BookMapper.toModel(bookDto);
            book.setLanguage(languageRepository.findById(bookDto.getLanguageId()).orElse(null));

            List<Author> authors = new ArrayList<>();
            bookDto.getContributions().forEach(bookContributionDto -> {
                Author author = AuthorMapper.toModel(bookContributionDto.getAuthor());
                if (authors.contains(author)) {
                    return;
                }
                Author existingAuthor = authorRepository.findById(author.getId()).orElse(null);
                if (existingAuthor != null) {
                    existingAuthor.setName(author.getName());
                    authors.add(existingAuthor);
                } else {
                    authors.add(authorRepository.save(author));
                }
            });
            book.setAuthors(authors);

            List<Genre> genres = new ArrayList<>();
            if (bookDto.getCached_tags() != null) {
                bookDto.getCached_tags().forEach(genreDto ->
                        genreRepository.findByGenreName(genreDto.getTag())
                                .ifPresentOrElse(
                                        genres::add,
                                        () -> genres.add(genreRepository.save(GenreMapper.toModel(genreDto)))
                                )
                );
            }
            book.setGenres(genres);

            book.setPublisher(publisherRepository.findById(bookDto.getPublisherId()).orElse(null));
            bookRepository.save(book);
        });
    }

}

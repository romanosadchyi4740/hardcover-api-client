package com.coursework.bookstore_graphql_client.service.impl;

import com.coursework.bookstore_graphql_client.client.BookstoreClient;
import com.coursework.bookstore_graphql_client.dto.LanguageDto;
import com.coursework.bookstore_graphql_client.mapper.LanguageMapper;
import com.coursework.bookstore_graphql_client.repository.LanguageRepository;
import com.coursework.bookstore_graphql_client.service.LanguageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final BookstoreClient bookstoreClient;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository, BookstoreClient bookstoreClient) {
        this.languageRepository = languageRepository;
        this.bookstoreClient = bookstoreClient;
    }

    @Override
    public List<LanguageDto> getLanguages() {
        return bookstoreClient.getLanguages();
    }

    @Transactional
    @Override
    public void saveLanguages(List<LanguageDto> languageDtos) {
        languageRepository.saveAll(languageDtos.stream().map(LanguageMapper::toModel).toList());
    }

}

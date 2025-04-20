package com.coursework.bookstore_graphql_client.service;

import com.coursework.bookstore_graphql_client.client.BookstoreClient;
import com.coursework.bookstore_graphql_client.dto.LanguageDto;
import com.coursework.bookstore_graphql_client.mapper.LanguageMapper;
import com.coursework.bookstore_graphql_client.repository.LanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final BookstoreClient bookstoreClient;

    @Autowired
    public LanguageService(LanguageRepository languageRepository, BookstoreClient bookstoreClient) {
        this.languageRepository = languageRepository;
        this.bookstoreClient = bookstoreClient;
    }

    public List<LanguageDto> getLanguages() {
        return bookstoreClient.getLanguages();
    }

    @Transactional
    public void saveLanguages(List<LanguageDto> languageDtos) {
        for (LanguageDto languageDto : languageDtos) {
            languageRepository.save(LanguageMapper.toModel(languageDto));
        }
    }

}

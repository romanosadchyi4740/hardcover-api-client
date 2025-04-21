package com.coursework.bookstore_graphql_client.service;

import com.coursework.bookstore_graphql_client.dto.LanguageDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface LanguageService {
    List<LanguageDto> getLanguages();

    @Transactional
    void saveLanguages(List<LanguageDto> languageDtos);
}

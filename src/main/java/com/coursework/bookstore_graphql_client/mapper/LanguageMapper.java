package com.coursework.bookstore_graphql_client.mapper;

import com.coursework.bookstore_graphql_client.dto.LanguageDto;
import com.coursework.bookstore_graphql_client.model.Language;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LanguageMapper {

    public static LanguageDto toDto(Language language) {
        return new LanguageDto(language.getId(), language.getLanguage());
    }

    public static Language toModel(LanguageDto languageDto) {
        return new Language(languageDto.getId(), languageDto.getLanguage());
    }

}

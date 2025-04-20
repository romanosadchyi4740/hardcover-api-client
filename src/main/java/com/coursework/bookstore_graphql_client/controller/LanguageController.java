package com.coursework.bookstore_graphql_client.controller;

import com.coursework.bookstore_graphql_client.dto.LanguageDto;
import com.coursework.bookstore_graphql_client.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<LanguageDto>> saveLanguages() {
        return ResponseEntity.ok(languageService.getLanguages());
    }

    @RequestMapping("/save")
    public void saveLanguage() {
        languageService.saveLanguages(languageService.getLanguages());
    }

}

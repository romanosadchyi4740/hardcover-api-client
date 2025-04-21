package com.coursework.bookstore_graphql_client.controller;

import com.coursework.bookstore_graphql_client.dto.PublisherDto;
import com.coursework.bookstore_graphql_client.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<PublisherDto>> getPublishers() {
        return ResponseEntity.ok(publisherService.getPublishers());
    }

    @RequestMapping("/save")
    public void savePublishers() {
        publisherService.savePublishers(publisherService.getPublishers());
    }

}

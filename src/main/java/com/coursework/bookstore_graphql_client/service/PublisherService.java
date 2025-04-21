package com.coursework.bookstore_graphql_client.service;

import com.coursework.bookstore_graphql_client.dto.PublisherDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PublisherService {
    List<PublisherDto> getPublishers();

    @Transactional
    void savePublishers(List<PublisherDto> publisherDtos);
}

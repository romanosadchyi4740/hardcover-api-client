package com.coursework.bookstore_graphql_client.service.impl;

import com.coursework.bookstore_graphql_client.client.BookstoreClient;
import com.coursework.bookstore_graphql_client.dto.PublisherDto;
import com.coursework.bookstore_graphql_client.mapper.PublisherMapper;
import com.coursework.bookstore_graphql_client.repository.PublisherRepository;
import com.coursework.bookstore_graphql_client.service.PublisherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final BookstoreClient bookstoreClient;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository, BookstoreClient bookstoreClient) {
        this.publisherRepository = publisherRepository;
        this.bookstoreClient = bookstoreClient;
    }

    @Override
    public List<PublisherDto> getPublishers() {
        return bookstoreClient.getPublishers();
    }

    @Transactional
    @Override
    public void savePublishers(List<PublisherDto> publisherDtos) {
        publisherRepository.saveAll(publisherDtos.stream().map(PublisherMapper::toModel).toList());
    }

}

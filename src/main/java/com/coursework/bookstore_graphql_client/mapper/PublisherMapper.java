package com.coursework.bookstore_graphql_client.mapper;

import com.coursework.bookstore_graphql_client.dto.PublisherDto;
import com.coursework.bookstore_graphql_client.model.Publisher;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PublisherMapper {

    public static Publisher toModel(PublisherDto publisherDto) {
        return new Publisher(publisherDto.getId(), publisherDto.getName());
    }

}

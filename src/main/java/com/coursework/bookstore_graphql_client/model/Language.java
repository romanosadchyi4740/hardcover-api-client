package com.coursework.bookstore_graphql_client.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "language")
public class Language {
    @Id
    @Column(name = "language_id")
    private int id;

    @Column(name = "language")
    private String language;
}

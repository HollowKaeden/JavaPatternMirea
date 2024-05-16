package ru.HollowKaeden.task15.entity;

import lombok.*;

import jakarta.persistence.*;


@Entity
@Data
@Builder
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private String creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Override
    public String toString() {
        return "Book{\n" +
                "name='" + name + "',\n" +
                "creationDate='" + creationDate + "'\n" +
                "}";
    }
}

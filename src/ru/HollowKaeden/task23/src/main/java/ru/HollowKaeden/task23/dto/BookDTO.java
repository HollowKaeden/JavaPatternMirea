package ru.HollowKaeden.task23.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.HollowKaeden.task23.entity.Author;


@Data
@AllArgsConstructor
public class BookDTO {
        private String name;
        private String creationDate;
        private Author author;
}
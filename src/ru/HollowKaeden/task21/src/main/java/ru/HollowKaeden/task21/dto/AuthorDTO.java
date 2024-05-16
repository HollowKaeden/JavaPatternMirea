package ru.HollowKaeden.task20.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.HollowKaeden.task20.entity.Book;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthorDTO {
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private List<Book> books;
}
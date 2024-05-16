package ru.HollowKaeden.task16.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.HollowKaeden.task16.dto.BookDTO;
import ru.HollowKaeden.task16.entity.Book;
import ru.HollowKaeden.task16.repository.BookRepository;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository repository;

    public Book addBook(BookDTO dto) {
        Book book = Book.builder()
                .name(dto.getName())
                .creationDate(dto.getCreationDate())
                .author(dto.getAuthor())
                .build();
        return repository.save(book);
    }

    public List<Book> readAll() {
        return repository.findAll();
    }

    public Optional<Book> getById(long id) { return repository.findById(id);}

    public Book update(Book book) {
        return repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
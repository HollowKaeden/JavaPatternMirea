package ru.HollowKaeden.task24.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.HollowKaeden.task24.dto.BookDTO;
import ru.HollowKaeden.task24.entity.Book;
import ru.HollowKaeden.task24.repository.BookRepository;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository bookRepository) {
        log.info("Created book repository");
        this.repository = bookRepository;
    }

    @Transactional
    public Book addBook(BookDTO dto) {
        log.info("Added new book");
        Book book = Book.builder()
                .name(dto.getName())
                .creationDate(dto.getCreationDate())
                .author(dto.getAuthor())
                .build();
        return repository.save(book);
    }

    @Transactional
    public List<Book> readAll() {
        log.info("Searched for all books");
        return repository.findAll();
    }

    @Transactional
    public Optional<Book> getById(long id) {
        log.info("Searched book by id " + id);
        return repository.findById(id);
    }

    @Transactional
    public Book update(Book book) {
        log.info("Updated a book");
        return repository.save(book);
    }

    @Transactional
    public boolean delete(Long id) {
        log.info("Deleted a book by id " + id);
        repository.deleteById(id);
        return true;
    }
}
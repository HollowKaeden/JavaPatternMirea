package ru.HollowKaeden.task22.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.HollowKaeden.task22.dto.AuthorDTO;
import ru.HollowKaeden.task22.entity.Author;
import ru.HollowKaeden.task22.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository authorRepository) {
        log.info("Created author repository");
        this.repository = authorRepository;
    }

    @Transactional
    public Author addAuthor(AuthorDTO dto) {
        log.info("Added new author");
        Author author = Author.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .middleName(dto.getMiddleName())
                .birthDate(dto.getBirthDate())
                .build();
        return repository.save(author);
    }

    @Transactional
    public List<Author> readAll() {
        log.info("Searched for all authors");
        return repository.findAll();
    }

    @Transactional
    public Optional<Author> getById(long id) {
        log.info("Searched author by id " + id);
        return repository.findById(id);
    }

    @Transactional
    public Author update(Author author) {
        log.info("Updated an author");
        return repository.save(author);
    }

    @Transactional
    public void delete(Long id) {
        log.info("Deleted an author by id " + id);
        repository.deleteById(id);
    }
}
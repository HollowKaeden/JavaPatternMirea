package ru.HollowKaeden.task18.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.HollowKaeden.task18.dto.AuthorDTO;
import ru.HollowKaeden.task18.entity.Author;
import ru.HollowKaeden.task18.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public Author addAuthor(AuthorDTO dto) {
        Author author = Author.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .middleName(dto.getMiddleName())
                .birthDate(dto.getBirthDate())
                .build();
        return repository.save(author);
    }

    public List<Author> readAll() {
        return repository.findAll();
    }

    public Optional<Author> getById(long id) { return repository.findById(id);}

    public Author update(Author author) {
        return repository.save(author);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
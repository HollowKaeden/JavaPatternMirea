package ru.HollowKaeden.task18.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.HollowKaeden.task18.dto.AuthorDTO;
import ru.HollowKaeden.task18.entity.Author;
import org.springframework.web.bind.annotation.*;
import ru.HollowKaeden.task18.service.AuthorService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/authors")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDTO dto) {
        return new ResponseEntity<>(authorService.addAuthor(dto), HttpStatus.OK);
    }

    @GetMapping(value="/authors")
    public ResponseEntity<List<Author>> read() {
        return new ResponseEntity<>(authorService.readAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/authors_sorted_by_firstName")
    public ResponseEntity<List<Author>> sort_by_firstName() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> authorCriteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = authorCriteriaQuery.from(Author.class);
        authorCriteriaQuery.select(root).orderBy(builder.asc(root.get("firstName")));
        Query query = entityManager.createQuery(authorCriteriaQuery);
        List<Author> sortedAuthors = query.getResultList();
        return new ResponseEntity<>(sortedAuthors, HttpStatus.OK);
    }

    @GetMapping(path = "/authors_sorted_by_lastName")
    public ResponseEntity<List<Author>> sort_by_lastName() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> authorCriteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = authorCriteriaQuery.from(Author.class);
        authorCriteriaQuery.select(root).orderBy(builder.asc(root.get("lastName")));
        Query query = entityManager.createQuery(authorCriteriaQuery);
        List<Author> sortedAuthors = query.getResultList();
        return new ResponseEntity<>(sortedAuthors, HttpStatus.OK);
    }

    @GetMapping(path = "/authors_sorted_by_middleName")
    public ResponseEntity<List<Author>> sort_by_middleName() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> authorCriteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = authorCriteriaQuery.from(Author.class);
        authorCriteriaQuery.select(root).orderBy(builder.asc(root.get("middleName")));
        Query query = entityManager.createQuery(authorCriteriaQuery);
        List<Author> sortedAuthors = query.getResultList();
        return new ResponseEntity<>(sortedAuthors, HttpStatus.OK);
    }

    @GetMapping(path = "/authors_sorted_by_birthDate")
    public ResponseEntity<List<Author>> sort_by_birthDate() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> authorCriteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = authorCriteriaQuery.from(Author.class);
        authorCriteriaQuery.select(root).orderBy(builder.asc(root.get("birthDate")));
        Query query = entityManager.createQuery(authorCriteriaQuery);
        List<Author> sortedAuthors = query.getResultList();
        return new ResponseEntity<>(sortedAuthors, HttpStatus.OK);
    }

    @GetMapping(value="/authors/{id}")
    public ResponseEntity<Author> read(@PathVariable(name="id") long id) {
        return new ResponseEntity<>(authorService.getById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping(value="/authors/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name="id") long id) {
        authorService.delete(id);
        Optional<Author> author = authorService.getById(id);
        if (author.isPresent()) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
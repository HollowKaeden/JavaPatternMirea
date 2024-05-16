package ru.HollowKaeden.task15.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.HollowKaeden.task15.dto.AuthorDTO;
import ru.HollowKaeden.task15.entity.Author;
import org.springframework.web.bind.annotation.*;
import ru.HollowKaeden.task15.service.AuthorService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping(value = "/authors")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDTO dto) {
        return new ResponseEntity<>(authorService.addAuthor(dto), HttpStatus.OK);
    }

    @GetMapping(value="/authors")
    public ResponseEntity<List<Author>> read() {
        return new ResponseEntity<>(authorService.readAll(), HttpStatus.OK);
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
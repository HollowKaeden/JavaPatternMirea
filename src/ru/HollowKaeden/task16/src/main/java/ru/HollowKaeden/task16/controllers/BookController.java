package ru.HollowKaeden.task16.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.HollowKaeden.task16.dto.BookDTO;
import org.springframework.web.bind.annotation.*;
import ru.HollowKaeden.task16.entity.Book;
import ru.HollowKaeden.task16.service.AuthorService;
import ru.HollowKaeden.task16.service.BookService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    @PostMapping(value = "/books")
    public ResponseEntity<Book> createBook(@RequestParam String name,
                                           @RequestParam String creationDate,
                                           @RequestParam Long authorId) {
        BookDTO dto = new BookDTO(name, creationDate, authorService.getById(authorId).get());
        return new ResponseEntity<Book>(bookService.addBook(dto), HttpStatus.OK);
    }

    @GetMapping(value="/books")
    public ResponseEntity<List<Book>> read() {
        return new ResponseEntity<List<Book>>(bookService.readAll(), HttpStatus.OK);
    }

    @GetMapping(value="/books/{id}")
    public ResponseEntity<Book> read(@PathVariable(name="id") long id) {
        return new ResponseEntity<>(bookService.getById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping(value="/books/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name="id") long id) {
        bookService.delete(id);
        Optional<Book> book = bookService.getById(id);
        if (book.isPresent()) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
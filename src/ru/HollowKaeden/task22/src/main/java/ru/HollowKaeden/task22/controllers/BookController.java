package ru.HollowKaeden.task22.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ru.HollowKaeden.task22.dto.BookDTO;
import org.springframework.web.bind.annotation.*;
import ru.HollowKaeden.task22.entity.Book;
import ru.HollowKaeden.task22.service.AuthorService;
import ru.HollowKaeden.task22.service.BookService;
import ru.HollowKaeden.task22.service.EmailService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class BookController {
    @Autowired
    private final BookService bookService;
    @Autowired
    private final AuthorService authorService;
    @Autowired
    private EmailService emailService;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/books")
    public ResponseEntity<Book> createBook(@RequestParam String name,
                                           @RequestParam String creationDate,
                                           @RequestParam Long authorId) {
        emailService.sendSimpleMessage("Book", "Added a book");
        BookDTO dto = new BookDTO(name, creationDate, authorService.getById(authorId).get());
        return new ResponseEntity<Book>(bookService.addBook(dto), HttpStatus.OK);
    }

    @GetMapping(value="/books")
    public ResponseEntity<List<Book>> read() {
        emailService.sendSimpleMessage("Book", "Got all books");
        return new ResponseEntity<List<Book>>(bookService.readAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/books_sorted_by_name")
    public ResponseEntity<List<Book>> sort_by_book_name() {
        emailService.sendSimpleMessage("Book", "Got all books sorted by name");
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> bookCriteriaQuery = builder.createQuery(Book.class);
        Root<Book> root = bookCriteriaQuery.from(Book.class);
        bookCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query query = entityManager.createQuery(bookCriteriaQuery);
        List<Book> sortedBooks = query.getResultList();
        return new ResponseEntity<>(sortedBooks, HttpStatus.OK);
    }

    @GetMapping(path = "/books_sorted_by_date")
    public ResponseEntity<List<Book>> sort_by_date() {
        emailService.sendSimpleMessage("Book", "Got all books sorted by date");
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> bookCriteriaQuery = builder.createQuery(Book.class);
        Root<Book> root = bookCriteriaQuery.from(Book.class);
        bookCriteriaQuery.select(root).orderBy(builder.asc(root.get("creationDate")));
        Query query = entityManager.createQuery(bookCriteriaQuery);
        List<Book> sortedBooks = query.getResultList();
        return new ResponseEntity<>(sortedBooks, HttpStatus.OK);
    }

    @GetMapping(value="/books/{id}")
    public ResponseEntity<Book> read(@PathVariable(name="id") long id) {
        emailService.sendSimpleMessage("Book", "Got a book by id " + id);
        return new ResponseEntity<>(bookService.getById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping(value="/books/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name="id") long id) {
        emailService.sendSimpleMessage("Book", "Deleted a book by id " + id);
        bookService.delete(id);
        Optional<Book> book = bookService.getById(id);
        if (book.isPresent()) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
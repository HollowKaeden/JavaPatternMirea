package ru.HollowKaeden.task14.controllers;

import ru.HollowKaeden.task14.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class BookController {
    private ArrayList<Book> list = new ArrayList<>();

    @PostMapping(value = "/add-book")
    @ResponseBody
    public String createBook(@RequestParam("name") String name,@RequestParam("creationDate") String creationDate) {
        System.out.println(name + " " + creationDate);
        Book book = new Book(name, creationDate);
        System.out.println("Added book");
        list.add(book);
        System.out.println(book);
        return book.toString();
    }

    @GetMapping(value = "/show-books")
    @ResponseBody
    public Object[] showBooks() {
        return list.stream()
                .filter(Objects::nonNull).toArray();
    }

    @DeleteMapping(value = "/delete-book")
    @ResponseBody
    public boolean deleteBook(@RequestParam("name") String name,@RequestParam("creationDate") String creationDate) {
        List<Book> rList = new ArrayList<>();
        list.stream()
                .filter(Objects::nonNull)
                .map(Book.class::cast)
                .filter(book -> book.getName().equals(name) &&
                        book.getCreationDate().equals(creationDate))
                .forEach(rList::add);
        list.removeAll(rList);
        return !rList.isEmpty();
    }
}
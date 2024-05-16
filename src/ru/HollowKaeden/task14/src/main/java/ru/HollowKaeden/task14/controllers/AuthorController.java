package ru.HollowKaeden.task14.controllers;

import ru.HollowKaeden.task14.entity.Author;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class AuthorController {
    private ArrayList<Author> list = new ArrayList<>();

    @PostMapping(value = "/add-author")
    @ResponseBody
    public String createAuthor(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("middleName") String middleName,
                               @RequestParam("birthDate") String birthDate) {
        System.out.println(firstName + " " + lastName + " " + middleName + " " + birthDate);
        Author author = new Author(firstName, lastName, middleName, birthDate);
        System.out.println("Added author");
        list.add(author);
        System.out.println(author);
        return author.toString();
    }

    @GetMapping(value = "/show-authors")
    @ResponseBody
    public Object[] showAuthors() {
        return list.stream()
                .filter(Objects::nonNull).toArray();
    }

    @DeleteMapping(value = "/delete-author")
    @ResponseBody
    public boolean deleteBook(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("middleName") String middleName,
                              @RequestParam("birthDate") String birthDate) {
        List<Author> rList = new ArrayList<>();
        list.stream()
                .filter(Objects::nonNull)
                .map(Author.class::cast)
                .filter(author -> author.getFirstName().equals(firstName) &&
                        author.getLastName().equals(lastName) &&
                        author.getMiddleName().equals(middleName) &&
                        author.getBirthDate().equals(birthDate))
                .forEach(rList::add);
        list.removeAll(rList);
        return !rList.isEmpty();
    }
}
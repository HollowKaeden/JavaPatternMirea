package ru.HollowKaeden.task14.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String name, creationDate;

    @Override
    public String toString() {
        return "Book{\n" +
                "name='" + name + "',\n" +
                "creationDate='" + creationDate + "'\n" +
                "}";
    }
}

package ru.HollowKaeden.task14.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Author {
    private String firstName, lastName, middleName, birthDate;

    @Override
    public String toString() {
        return "Author{\n" +
                "firstName='" + firstName + "',\n" +
                "lastName='" + lastName + "',\n" +
                "middleName='" + middleName + "',\n" +
                "birthDate='" + birthDate + "'\n" +
                "}";
    }
}

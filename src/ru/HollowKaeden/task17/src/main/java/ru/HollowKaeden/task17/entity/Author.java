package ru.HollowKaeden.task17.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date")
    private String birthDate;

    @OneToMany(mappedBy="author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Book> books;


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

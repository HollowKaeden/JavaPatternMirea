package ru.HollowKaeden.task20.repository;

import ru.HollowKaeden.task20.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
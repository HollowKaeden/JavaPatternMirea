package ru.HollowKaeden.task18.repository;

import ru.HollowKaeden.task18.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
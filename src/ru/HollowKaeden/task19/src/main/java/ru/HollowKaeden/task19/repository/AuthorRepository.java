package ru.HollowKaeden.task19.repository;

import ru.HollowKaeden.task19.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
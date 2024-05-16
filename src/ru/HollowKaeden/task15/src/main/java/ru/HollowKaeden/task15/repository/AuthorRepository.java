package ru.HollowKaeden.task15.repository;

import ru.HollowKaeden.task15.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
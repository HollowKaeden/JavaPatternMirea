package ru.HollowKaeden.task16.repository;

import ru.HollowKaeden.task16.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
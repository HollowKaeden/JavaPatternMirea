package ru.HollowKaeden.task24.service;


import ru.HollowKaeden.task24.entity.Book;
import ru.HollowKaeden.task24.entity.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@ManagedResource(objectName = "ru.HollowKaeden:type=scheduleService")
public class ScheduleService {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private void makeBooksBackup() {
        List<Book> books = bookService.readAll();
        try {
            RandomAccessFile writer = new RandomAccessFile("backup\\books.txt", "rw");
            writer.setLength(0);
            for (Book book : books) {
                String bookStr = String.format("%d %s %s %d\n",
                        book.getId(),
                        book.getName(),
                        book.getCreationDate(),
                        book.getAuthor().getId());
                writer.write(bookStr.getBytes());
            }
            writer.close();
        } catch (IOException e) {
            log.error("Error occurred while writing books backup: {}", e.getMessage());
        }
    }

    private void makeAuthorsBackup() {
        List<Author> authors = authorService.readAll();
        try {
            RandomAccessFile writer = new RandomAccessFile("backup\\authors.txt", "rw");
            writer.setLength(0);
            for (Author author : authors) {
                String authorStr = String.format("%d %s %s %s %s\n",
                        author.getId(),
                        author.getFirstName(),
                        author.getLastName(),
                        author.getMiddleName(),
                        author.getBirthDate());
                writer.write(authorStr.getBytes());
            }
            writer.close();
        } catch (IOException e) {
            log.error("Error occurred while writing games backup: {}", e.getMessage());
        }
    }

    @Scheduled(cron = "0 */30 * * * *")
    public void makeBackup() {
        System.out.println("Made a backup!");
        makeBooksBackup();
        makeAuthorsBackup();
        log.info("Backups are made: {}", dateFormat.format(new Date()));
    }
}
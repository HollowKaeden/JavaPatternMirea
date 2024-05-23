package ru.HollowKaeden.task24;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.HollowKaeden.task24.dto.BookDTO;
import ru.HollowKaeden.task24.entity.Book;
import ru.HollowKaeden.task24.repository.BookRepository;
import ru.HollowKaeden.task24.service.AuthorService;
import ru.HollowKaeden.task24.service.BookService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;
    private AuthorService authorService;

    @Test
    public void testCreate() {
        Book expectedBook = new Book(null, "name", "date", authorService.getById(3).get());
        BookDTO dto = new BookDTO("name", "date", authorService.getById(3).get());
        when(bookRepository.save(any())).thenReturn(expectedBook);
        Book createdBook = bookService.addBook(dto);
        verify(bookRepository, times(1)).save(any());
        expectedBook.setId(createdBook.getId());
        assertEquals(expectedBook, createdBook);
    }

    @Test
    public void testReadAll() {
        Book expectedBook1 = new Book(8L, "bookName", "Some Date", authorService.getById(3).get());
        Book expectedBook2 = new Book(9L, "bookName2", "Some Date2", authorService.getById(3).get());
        Book expectedBook3 = new Book(10L, "bookName3", "Some Date3", authorService.getById(3).get());
        Book expectedBook4 = new Book(11L, "bookName4", "Some Date4", authorService.getById(3).get());
        List<Book> expectedBooks = Arrays.asList(
                expectedBook1,
                expectedBook2,
                expectedBook3,
                expectedBook4
        );
        when(bookRepository.findAll()).thenReturn(expectedBooks);
        List<Book> books = bookService.readAll();
        verify(bookRepository, times(1)).findAll();
        assertEquals(expectedBooks, books);
    }

    @Test
    public void testRead() {
        Book expectedBook = new Book(8L, "bookName", "Some Date", authorService.getById(3).get());
        when(bookRepository.findById(expectedBook.getId())).thenReturn(Optional.of(expectedBook));
        Book readBook = bookService.getById(8L).get();
        verify(bookRepository, times(1)).findById(expectedBook.getId());
        assertEquals(expectedBook, readBook);
    }

    @Test
    public void testUpdate() {
        Book expectedBook = new Book(8L, "bookName", "Some Date", authorService.getById(3).get());
        when(bookRepository.existsById(8L)).thenReturn(true);
        when(bookRepository.save(any())).thenReturn(expectedBook);
        Book updatedBook = bookService.update(expectedBook);
        verify(bookRepository, times(1)).save(expectedBook);
        assertEquals(expectedBook, updatedBook);
    }

    @Test
    public void testDelete() {
        Long id = 11L;
        when(bookRepository.existsById(id)).thenReturn(true);
        boolean isDeleted = bookService.delete(id);
        verify(bookRepository, times(1)).deleteById(id);
        assertTrue(isDeleted);
    }

}
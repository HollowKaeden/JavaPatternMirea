package ru.HollowKaeden.task24;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.HollowKaeden.task24.dto.AuthorDTO;
import ru.HollowKaeden.task24.dto.BookDTO;
import ru.HollowKaeden.task24.entity.Author;
import ru.HollowKaeden.task24.entity.Book;
import ru.HollowKaeden.task24.repository.AuthorRepository;
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
public class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private AuthorService authorService;


    @Test
    public void testCreate() {
        Author expectedAuthor = new Author(null, "FirstName", "lastName", "middleName", "birthDate", null);
        AuthorDTO dto = new AuthorDTO("FirstName", "lastName", "middleName", "birthDate", null);
        when(authorRepository.save(any())).thenReturn(expectedAuthor);
        Author createdAuthor = authorService.addAuthor(dto);
        verify(authorRepository, times(1)).save(any());
        expectedAuthor.setId(createdAuthor.getId());
        assertEquals(expectedAuthor, createdAuthor);
    }

    @Test
    public void testReadAll() {
        Author expectedAuthor = new Author(3L, "FirstName", "lastName", "middleName", "birthDate", authorService.getById(3L).get().getBooks());
        List<Author> expectedAuthors = Arrays.asList(
                expectedAuthor
        );
        when(authorRepository.findAll()).thenReturn(expectedAuthors);
        List<Author> authors = authorService.readAll();
        verify(authorRepository, times(1)).findAll();
        assertEquals(expectedAuthors, authors);
    }

    @Test
    public void testRead() {
        Author expectedAuthor = new Author(3L, "FirstName", "lastName", "middleName", "birthDate", authorService.getById(3L).get().getBooks());
        when(authorRepository.findById(expectedAuthor.getId())).thenReturn(Optional.of(expectedAuthor));
        Author readAuthor = authorService.getById(3L).get();
        verify(authorRepository, times(1)).findById(expectedAuthor.getId());
        assertEquals(expectedAuthor, readAuthor);
    }

    @Test
    public void testUpdate() {
        Author expectedAuthor = new Author(3L, "FirstName", "lastName", "middleName", "birthDate", authorService.getById(3L).get().getBooks());
        when(authorRepository.existsById(3L)).thenReturn(true);
        when(authorRepository.save(any())).thenReturn(expectedAuthor);
        Author updatedAuthor = authorService.update(expectedAuthor);
        verify(authorRepository, times(1)).save(expectedAuthor);
        assertEquals(expectedAuthor, updatedAuthor);
    }

    @Test
    public void testDelete() {
        Long id = 3L;
        when(authorRepository.existsById(id)).thenReturn(true);
        boolean isDeleted = authorService.delete(id);
        verify(authorRepository, times(1)).deleteById(id);
        assertTrue(isDeleted);
    }
}
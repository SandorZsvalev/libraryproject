package org.telran.library.project.service;

import org.junit.jupiter.api.Test;
import org.telran.library.project.model.Book;
import org.telran.library.project.repository.BookRepository;
import org.telran.library.project.repository.BookRepositoryImpl;
import org.telran.library.project.repository.SaveAndRead;
import org.telran.library.project.repository.SaveAndReadImpl;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    SaveAndRead saveAndRead = new SaveAndReadImpl();
    BookRepository bookRepository = new BookRepositoryImpl(saveAndRead);
    BookService bookService = new BookServiceImpl(bookRepository, saveAndRead);

    @Test
    void getAllFromBooksRepository() {
        assertArrayEquals(bookRepository.getBooks().toArray(), bookService.getAllFromBooksRepository().toArray());
    }

    @Test
    void addToBookRepository() {
        Book book = new Book("Test", "Tester", 1111);
        assertTrue(bookService.addToBookRepository(book));
        assertFalse(bookService.addToBookRepository(null));
    }

    @Test
    void FindBook() {
        Book book = new Book("Test","Tester",1111);
        bookService.addToBookRepository(book);
        assertEquals(book,bookService.findBook(1111));
    }

    @Test
    void deleteFromBooksRepository() {
        Book book = new Book("Test", "Tester", 1111);
        bookService.addToBookRepository(book);
        Book wrongBook = bookService.findBook(9999);
        assertTrue(bookService.deleteFromBooksRepository(book));
        assertFalse(bookService.deleteFromBooksRepository(wrongBook));
    }

}

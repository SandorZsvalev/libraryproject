package org.telran.library.project.service;

import org.junit.jupiter.api.Test;
import org.telran.library.project.model.Book;
import org.telran.library.project.repository.BookRepository;
import org.telran.library.project.repository.BookRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    BookRepository bookRepository = new BookRepositoryImpl();
    BookService bookService = new BookServiceImpl(bookRepository);
    @Test
    void getAllFromBooksRepository() {
        assertArrayEquals(bookRepository.getBooks().toArray(), bookService.getAllFromBooksRepository().toArray());
    }

    @Test
    void addToBookRepository() {
        Book book = new Book("Test","Tester",1111);
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
        Book book = bookService.findBook(1043);
        Book wrongBook = bookService.findBook(1045);
        assertTrue(bookService.deleteFromBooksRepository(book));
        assertFalse(bookService.deleteFromBooksRepository(wrongBook));
    }

}
package org.telran.library.project.service;

import org.telran.library.project.model.Book;
import org.telran.library.project.repository.BookRepository;
import org.telran.library.project.repository.SaveAndRead;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    SaveAndRead saveAndRead;


    public BookServiceImpl(BookRepository bookRepository, SaveAndRead saveAndRead) {
        this.bookRepository = bookRepository;
        this.saveAndRead = saveAndRead;
    }

    @Override
    public List<Book> getAllFromBooksRepository() {
        return bookRepository.getBooks();
    }

    @Override
    public boolean deleteFromBooksRepository(Book book) {
        List <Book> books = bookRepository.getBooks();
        return books.remove(book);
    }

    @Override
    public boolean addToBookRepository(Book book) {
        if (book==null){
            System.out.println("Такой книги не обнаружено");
            return false;
        }
        List <Book> books = bookRepository.getBooks();
        books.add(book);
        return true;
    }

    @Override
    public Book findBook(int isbn) {
        return bookRepository.getBooks().stream().filter(book -> book.getIsbn() == isbn).findFirst().orElse(null);
    }

    public void writeBookRepositoryToJson() {
        saveAndRead.writeBooksToRepository(bookRepository.getBooks());
    }
}

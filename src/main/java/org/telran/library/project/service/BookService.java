package org.telran.library.project.service;

import org.telran.library.project.model.Book;

import java.util.List;

public interface BookService {

    /*1)Получить полный список книг из хранилища книг.
2)Убрать книгу из хранилища книг.
3)Поместить книгу в хранилище*/

    List<Book> getAllFromBooksRepository();
    boolean deleteFromBooksRepository(Book book);
    boolean addToBookRepository(Book book);

    Book findBook (int isbn);

    void writeBookRepositoryToJson();

}

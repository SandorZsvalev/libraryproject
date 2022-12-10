package org.telran.library.project.service;

import org.telran.library.project.model.Book;

import java.util.List;

public interface OrderService {

    /*Вывести полный список книг у определенного пользователя
Добавить книгу к определенному пользователю,
Убрать книгу у определенного пользователя*/
    List<Book> getAllFromHomeRepository();
    boolean addBookToHomeRepository(Book book);
    boolean deleteBookFormHomeRepository(Book book);

    Book findUsersBook (int isbn);
}

package org.telran.library.project.service;

import org.telran.library.project.model.Book;

import java.util.List;

public interface HomeRepositoryService {

    List<Book> getUserBooks(int userId);

    void writeHomeRepository();

    boolean checkIfUserExist(int userId);

    void addNewUser(int userId);
}

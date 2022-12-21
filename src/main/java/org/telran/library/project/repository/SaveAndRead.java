package org.telran.library.project.repository;

import org.telran.library.project.model.Book;
import org.telran.library.project.model.User;

import java.util.List;
import java.util.Map;

public interface SaveAndRead {

    List<Book> readBooksFromRepository();

    void writeBooksToRepository(List<Book> books);

    List<User> readUsersFromRepository();

    void writeUserListToRepository(List<User> users);

    Map<Integer, List<Book>> readBooksFromHomeRepository();

    void writeBooksToHomeRepository(Map<Integer, List<Book>> mapHomeRep);
}

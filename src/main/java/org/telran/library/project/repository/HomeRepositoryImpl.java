package org.telran.library.project.repository;

import org.telran.library.project.model.Book;

import java.util.ArrayList;
import java.util.List;

public class HomeRepositoryImpl implements HomeRepository{

    private List <Book> usersBooks;

    public HomeRepositoryImpl() {
        usersBooks = new ArrayList<>();
    }

    public List<Book> getUsersBooks() {
        return usersBooks;
    }

    @Override
    public String toString() {
        return "HomeRepositoryImpl{" +
                "usersBooks=" + usersBooks +
                '}';
    }
}

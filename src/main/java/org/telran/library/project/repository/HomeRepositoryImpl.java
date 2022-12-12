package org.telran.library.project.repository;

import org.telran.library.project.model.Book;

import java.util.ArrayList;
import java.util.List;

public class HomeRepositoryImpl implements HomeRepository{

    private List <Book> usersBooks;

    private String type;

    public HomeRepositoryImpl() {
        usersBooks = new ArrayList<>();
        this.type = "HomeRepositoryImpl";
    }

    public List<Book> getUsersBooks() {
        return usersBooks;
    }

    public void setUsersBooks(List<Book> usersBooks) {
        this.usersBooks = usersBooks;
    }

    @Override
    public String toString() {
        return "HomeRepositoryImpl{" +
                "usersBooks=" + usersBooks +
                '}';
    }
}

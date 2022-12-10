package org.telran.library.project.repository;

import com.google.gson.InstanceCreator;
import org.telran.library.project.model.Book;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HomeRepositoryCreator implements InstanceCreator<HomeRepository> {

    private List<Book> usersBooks;

    public HomeRepositoryCreator() {
        usersBooks = new ArrayList<>();
    }


    @Override
    public HomeRepository createInstance(Type type) {
        HomeRepository homeRepository = new HomeRepositoryImpl();
        return homeRepository;
    }
}

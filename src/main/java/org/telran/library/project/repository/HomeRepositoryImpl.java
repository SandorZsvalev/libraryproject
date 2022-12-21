package org.telran.library.project.repository;

import org.telran.library.project.model.Book;

import java.util.List;
import java.util.Map;

public class HomeRepositoryImpl implements HomeRepository {

    SaveAndRead saveAndRead;
    private Map<Integer, List<Book>> homeRepository;
    private String type;

    public HomeRepositoryImpl(SaveAndRead saveAndRead) {
//        homeRepository = new HashMap<>();
        homeRepository = saveAndRead.readBooksFromHomeRepository();
        this.type = "HomeRepositoryImpl";
    }

    public Map<Integer, List<Book>> getHomeRepository() {
        return homeRepository;
    }

    public void setHomeRepository(Map<Integer, List<Book>> homeRepository) {
        this.homeRepository = homeRepository;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HomeRepositoryImpl{" +
                "homeRepository=" + homeRepository +
                '}';
    }
}

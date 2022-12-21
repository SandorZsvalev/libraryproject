package org.telran.library.project.service;

import org.telran.library.project.model.Book;
import org.telran.library.project.repository.HomeRepository;
import org.telran.library.project.repository.SaveAndRead;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeRepositoryServiceImpl implements HomeRepositoryService {

    HomeRepository homeRepository;

    SaveAndRead saveAndRead;

    public HomeRepositoryServiceImpl(HomeRepository homeRepository, SaveAndRead saveAndRead) {
        this.homeRepository = homeRepository;
        this.saveAndRead = saveAndRead;
    }

    public List<Book> getUserBooks(int userId) {
        List<Book> zeroList = new ArrayList<>();
        Map<Integer, List<Book>> mainHomeRep = homeRepository.getHomeRepository();
        return mainHomeRep.getOrDefault(userId, zeroList);
    }

    @Override
    public void writeHomeRepository() {
        saveAndRead.writeBooksToHomeRepository(homeRepository.getHomeRepository());
    }

    public boolean checkIfUserExist(int userId) {
        return homeRepository.getHomeRepository().containsKey(userId);
    }

    public void addNewUser(int userId) {
        homeRepository.getHomeRepository().put(userId, new ArrayList<>());
    }
}

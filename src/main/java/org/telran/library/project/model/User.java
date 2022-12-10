package org.telran.library.project.model;

import org.telran.library.project.repository.HomeRepository;
import org.telran.library.project.repository.HomeRepositoryImpl;

public class User {

    private String name;
    private int userId;
    //TODO - пока не удалось добиться, чтобы Gson десериализовал из интерфейса. Временно заменил на имплементацию
//    private HomeRepository homeRepository;
    private HomeRepositoryImpl homeRepository;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
        homeRepository = new HomeRepositoryImpl();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //TODO - здесь надо будет потом вернуть как было
//    public void setHomeRepository(HomeRepository homeRepository) {
//        this.homeRepository = homeRepository;
//    }

    public void setHomeRepository(HomeRepositoryImpl homeRepository) {
        this.homeRepository = homeRepository;
    }

    public HomeRepository getHomeRepository() {
        return homeRepository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                ", homeRepository=" + homeRepository +
                '}';
    }


}

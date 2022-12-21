package org.telran.library.project.service;

import org.telran.library.project.model.Book;
import org.telran.library.project.model.User;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    User user;
    HomeRepositoryService homeRepositoryService;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HomeRepositoryService getHomeRepositoryService() {
        return homeRepositoryService;
    }

    public void setHomeRepositoryService(HomeRepositoryService homeRepositoryService) {
        this.homeRepositoryService = homeRepositoryService;
    }

    @Override
    public List<Book> getAllFromHomeRepository() {
        return homeRepositoryService.getUserBooks(user.getUserId());
    }

    @Override
    public boolean addBookToHomeRepository(Book book) {
        if (book == null) {
            System.out.println("Такой книги не обнаружено");
            return false;
        }
        if (homeRepositoryService.checkIfUserExist(user.getUserId())) {
            homeRepositoryService.getUserBooks(user.getUserId()).add(book);
            System.out.println("Успешно добавлена");
        } else {
            homeRepositoryService.addNewUser(user.getUserId());
            System.out.println("Добавлен новый юзер");
            homeRepositoryService.getUserBooks(user.getUserId()).add(book);
            System.out.println("Добавлена новая книга");
        }
        System.out.println(homeRepositoryService.getUserBooks(user.getUserId()));
        return true;
    }

    @Override
    public boolean deleteBookFormHomeRepository(Book book) {
        List<Book> listOfUsersBooks = homeRepositoryService.getUserBooks(user.getUserId());
        return listOfUsersBooks.remove(book);
    }

    @Override
    public Book findUsersBook(int isbn) {
        return homeRepositoryService.getUserBooks(user.getUserId()).stream().filter(book -> book.getIsbn() == isbn).findFirst().orElse(null);
    }
}

package org.telran.library.project.service;

import org.telran.library.project.model.Book;
import org.telran.library.project.model.User;
import org.telran.library.project.repository.HomeRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    User user;
    HomeRepository homeRepository;

    public OrderServiceImpl(User user) {
        this.user = user;
        homeRepository = user.getHomeRepository();
    }

    @Override
    public List<Book> getAllFromHomeRepository() {
        return homeRepository.getUsersBooks();
    }

    @Override
    public boolean addBookToHomeRepository(Book book) {
        if (book==null){
            System.out.println("Такой книги не обнаружено");
            return false;
        }
        List<Book> listOfUsersBooks = homeRepository.getUsersBooks();
        listOfUsersBooks.add(book);
        return true;
    }

    @Override
    public boolean deleteBookFormHomeRepository(Book book) {
        List<Book> listOfUsersBooks = homeRepository.getUsersBooks();
        return listOfUsersBooks.remove(book);
    }

    @Override
    public Book findUsersBook(int isbn) {
        return homeRepository.getUsersBooks().stream().filter(book -> book.getIsbn() == isbn).findFirst().orElse(null);
    }
}

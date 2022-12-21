package org.telran.library.project.service;

import org.junit.jupiter.api.Test;
import org.telran.library.project.model.Book;
import org.telran.library.project.model.User;
import org.telran.library.project.repository.HomeRepository;
import org.telran.library.project.repository.HomeRepositoryImpl;
import org.telran.library.project.repository.SaveAndRead;
import org.telran.library.project.repository.SaveAndReadImpl;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    User user = new User("TestName", 11);
    SaveAndRead saveAndRead = new SaveAndReadImpl();
    HomeRepository homeRepository = new HomeRepositoryImpl(saveAndRead);
    HomeRepositoryService homeRepositoryService = new HomeRepositoryServiceImpl(homeRepository, saveAndRead);
    OrderService orderService = new OrderServiceImpl();

    @Test
    void getAllFromHomeRepository() {
        orderService.setUser(user);
        orderService.setHomeRepositoryService(homeRepositoryService);
        Book book = new Book("Test", "Tester", 1111);
        orderService.addBookToHomeRepository(book);
        Object[] expectedArray = homeRepositoryService.getUserBooks(user.getUserId()).toArray();
        Object[] actualArray = orderService.getAllFromHomeRepository().toArray();
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void addBookToHomeRepository() {
        orderService.setUser(user);
        orderService.setHomeRepositoryService(homeRepositoryService);
        Book book = new Book("Test", "Tester", 1111);
        assertTrue(orderService.addBookToHomeRepository(book));
        assertFalse(orderService.addBookToHomeRepository(null));
    }

    @Test
    void findUsersBook() {
        orderService.setUser(user);
        orderService.setHomeRepositoryService(homeRepositoryService);
        Book book = new Book("Test", "Tester", 1111);
        orderService.addBookToHomeRepository(book);
        assertEquals(book, orderService.findUsersBook(1111));
    }

    @Test
    void deleteBookFormHomeRepository() {
        orderService.setUser(user);
        orderService.setHomeRepositoryService(homeRepositoryService);
        Book book = new Book("Test", "Tester", 1111);
        orderService.addBookToHomeRepository(book);
        assertTrue(orderService.deleteBookFormHomeRepository(book));
        assertFalse(orderService.deleteBookFormHomeRepository(null));
    }


}

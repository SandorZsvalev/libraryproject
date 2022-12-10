package org.telran.library.project.service;

import org.junit.jupiter.api.Test;
import org.telran.library.project.model.Book;
import org.telran.library.project.model.User;
import org.telran.library.project.repository.HomeRepository;
import org.telran.library.project.repository.HomeRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    User user = new User("TestName",11);
    OrderService orderService = new OrderServiceImpl(user);

    @Test
    void getAllFromHomeRepository() {
        Book book = new Book("Test", "Tester", 1111);
        orderService.addBookToHomeRepository(book);
        Object [] expectedArray = user.getHomeRepository().getUsersBooks().toArray();
        Object [] actualArray = orderService.getAllFromHomeRepository().toArray();
        assertArrayEquals(expectedArray,actualArray);
    }

    @Test
    void addBookToHomeRepository() {
        Book book = new Book("Test", "Tester", 1111);
        assertTrue(orderService.addBookToHomeRepository(book));
        assertFalse(orderService.addBookToHomeRepository(null));
    }

    @Test
    void findUsersBook() {
        Book book = new Book("Test", "Tester", 1111);
        orderService.addBookToHomeRepository(book);
        assertEquals(book,orderService.findUsersBook(1111));
    }

    @Test
    void deleteBookFormHomeRepository() {
        Book book = new Book("Test", "Tester", 1111);
        orderService.addBookToHomeRepository(book);
        assertTrue(orderService.deleteBookFormHomeRepository(book));
        assertFalse(orderService.deleteBookFormHomeRepository(null));
    }


}
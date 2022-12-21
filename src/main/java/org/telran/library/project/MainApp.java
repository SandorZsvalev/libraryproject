package org.telran.library.project;

import org.telran.library.project.controller.UserController;
import org.telran.library.project.repository.*;
import org.telran.library.project.service.*;

public class MainApp {
    public static void main(String[] args) {

        SaveAndRead saveAndRead = new SaveAndReadImpl();
        UserRepository userRepository = new UserRepositoryImpl(saveAndRead);
        UserService userService = new UserServiceImpl(userRepository, saveAndRead);

        BookRepository bookRepository = new BookRepositoryImpl(saveAndRead);
        BookService bookService = new BookServiceImpl(bookRepository, saveAndRead);

        HomeRepository homeRepository = new HomeRepositoryImpl(saveAndRead);
        HomeRepositoryService homeRepositoryService = new HomeRepositoryServiceImpl(homeRepository, saveAndRead);

        OrderService orderService = new OrderServiceImpl();

        UserController userController = new UserController(userService, bookService, homeRepositoryService, orderService);
        userController.menu();


    }
}

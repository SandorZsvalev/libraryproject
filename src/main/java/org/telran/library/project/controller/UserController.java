package org.telran.library.project.controller;

import org.telran.library.project.model.User;
import org.telran.library.project.service.BookService;
import org.telran.library.project.service.HomeRepositoryService;
import org.telran.library.project.service.OrderService;
import org.telran.library.project.service.UserService;

import java.util.Scanner;

public class UserController {

    UserService userService;

    BookService bookService;

    HomeRepositoryService homeRepositoryService;

    OrderService orderService;

    public UserController(UserService userService, BookService bookService, HomeRepositoryService homeRepositoryService, OrderService orderService) {
        this.userService = userService;
        this.bookService = bookService;
        this.homeRepositoryService = homeRepositoryService;
        this.orderService = orderService;
    }

    public void logIn() {
        System.out.println("Введите id пользователя");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int id = Integer.parseInt(String.valueOf(input));
        User user = userService.userLogIn(id);
        orderService.setUser(user);
        orderService.setHomeRepositoryService(homeRepositoryService);
        Controller controller = new Controller(bookService, orderService);
        controller.menu();
    }

    private void showAllUsers(){
        userService.showAllUsers();
    }

    private void saveAndExit(){
        userService.writeUserListToJson();
        bookService.writeBookRepositoryToJson();
        homeRepositoryService.writeHomeRepository();
    }

    private int mainFirstMenu (){
        System.out.println("\n<---    ГЛАВНОЕ МЕНЮ    ---> \n" +
                "1 - показать список пользователей\n" +
                "2 - войти в систему\n" +
                "3 - сохранить изменения и выйти\n" +
                "0 - выйти из системы без сохранения");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Integer.parseInt(String.valueOf(input.charAt(0)));
    }

    public void menu () {
        int choise = mainFirstMenu();
        while (choise != 0) {
            switch (choise) {
                case 1: {
                    showAllUsers();
                    break;
                }
                case 2: {
                    logIn();
                    break;
                }
                case 3:{
                    saveAndExit();
                    System.exit(0);
                }
            }
            choise = mainFirstMenu();
        }
    }


}

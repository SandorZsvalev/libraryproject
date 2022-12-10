package org.telran.library.project;

import org.telran.library.project.controller.UserController;

public class MainApp {
    public static void main(String[] args) {

        UserController userController = new UserController();
        userController.menu();


    }
}

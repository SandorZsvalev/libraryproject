package org.telran.library.project.service;

import org.telran.library.project.model.User;


public interface UserService {

    User findUserById(int id);

    User createUser(String name, int id);

    boolean deleteUser(int id);

    void writeUserListToJson ();

    User userLogIn(int id);

    void showAllUsers();
}

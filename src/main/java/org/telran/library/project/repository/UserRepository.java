package org.telran.library.project.repository;

import org.telran.library.project.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsersList();

    public List<User> readUsersFromJson();

    void writeUserListToJson();
}

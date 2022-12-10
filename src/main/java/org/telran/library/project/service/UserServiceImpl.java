package org.telran.library.project.service;

import org.telran.library.project.model.User;
import org.telran.library.project.repository.*;
import java.util.List;

public class UserServiceImpl implements UserService{

    private List<User> usersList;
    UserRepository userRepository = new UserRepositoryImpl();

    public UserServiceImpl() {
        usersList = userRepository.getUsersList();
    }

    @Override
    public User findUserById(int id) {
        return usersList.stream().filter(user -> user.getUserId() == id).findFirst().orElse(null);
    }

    @Override
    public User createUser(String name, int id) {
        return new User(name, id);
    }

    @Override
    public boolean deleteUser(int id) {
        User user = findUserById(id);
        return usersList.remove(user);
    }

    @Override
    public void writeUserListToJson() {
        userRepository.writeUserListToJson();
    }

    public User userLogIn(int id){
        User user = findUserById(id);
        if (user != null){
            return user;
        } else {
            System.out.println("Пользователь не найден");
            return null;
        }
    }


    @Override
    public void showAllUsers() {
        usersList.forEach(System.out::println);
    }
}

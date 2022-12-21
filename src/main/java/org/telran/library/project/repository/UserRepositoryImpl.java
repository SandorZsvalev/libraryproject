package org.telran.library.project.repository;

import org.telran.library.project.model.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    List<User> users;

    SaveAndRead saveAndRead;

    public UserRepositoryImpl(SaveAndRead saveAndRead) {
        this.saveAndRead = saveAndRead;
        users = saveAndRead.readUsersFromRepository();
//        users = new ArrayList<>();
//        init();
    }

    public List<User> getUsersList() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public SaveAndRead getSaveAndRead() {
        return saveAndRead;
    }

    public void setSaveAndRead(SaveAndRead saveAndRead) {
        this.saveAndRead = saveAndRead;
    }

    public void init() {
        users.add(new User("Alex", 1));
        users.add(new User("Petr", 2));
        users.add(new User("Ivan", 3));
    }
}

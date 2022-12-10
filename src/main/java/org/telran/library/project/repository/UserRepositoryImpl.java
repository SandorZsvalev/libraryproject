package org.telran.library.project.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.telran.library.project.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    List<User> users;

    public UserRepositoryImpl() {
        users = readUsersFromJson();
    }

    @Override
    public List<User> getUsersList() {
        return users;
    }

    public List<User> readUsersFromJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(HomeRepository.class, new HomeRepositoryCreator());
        Gson gson = gsonBuilder.create();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/user_list.json"));
            Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
            List<User> list = gson.fromJson(br, userListType);
//            list.forEach(System.out::println);
            return list;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void writeUserListToJson() {
        Gson gson = new Gson();
        String jsonUserList = gson.toJson(users);
        try {
            FileWriter file = new FileWriter("src/main/resources/user_list.json");
            file.write(jsonUserList);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

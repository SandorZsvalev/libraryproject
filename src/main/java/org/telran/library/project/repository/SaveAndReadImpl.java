package org.telran.library.project.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.telran.library.project.model.Book;
import org.telran.library.project.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SaveAndReadImpl implements SaveAndRead {

    @Override
    public List<Book> readBooksFromRepository() {
        Gson gson = new Gson();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/book_repository.json"));
            Type bookListType = new TypeToken<ArrayList<Book>>() {
            }.getType();
            List<Book> list = gson.fromJson(bufferedReader, bookListType);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeBooksToRepository(List<Book> books) {
        Gson gson = new Gson();
        String jsonUserList = gson.toJson(books);
        try {
            FileWriter file = new FileWriter("src/main/resources/book_repository.json");
            file.write(jsonUserList);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> readUsersFromRepository() {
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/user_list.json"));
            Type userListType = new TypeToken<ArrayList<User>>() {
            }.getType();
            List<User> list = gson.fromJson(br, userListType);
            list.forEach(System.out::println);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeUserListToRepository(List<User> users) {
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

    @Override
    public Map<Integer, List<Book>> readBooksFromHomeRepository() {
        Gson gson = new Gson();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/book_home_repository.json"));
            Type bookListType = new TypeToken<Map<Integer, List<Book>>>() {
            }.getType();
            Map<Integer, List<Book>> mapHomeRep = gson.fromJson(bufferedReader, bookListType);
            return mapHomeRep;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeBooksToHomeRepository(Map<Integer, List<Book>> mapHomeRep) {
        Gson gson = new Gson();
        String jsonUserList = gson.toJson(mapHomeRep);
        try {
            FileWriter file = new FileWriter("src/main/resources/book_home_repository.json");
            file.write(jsonUserList);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

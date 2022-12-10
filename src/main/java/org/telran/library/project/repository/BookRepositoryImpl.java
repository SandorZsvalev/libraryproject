package org.telran.library.project.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.telran.library.project.model.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository{

    private List<Book> books;

    //временно оставляю на случай дальнейших доработок и переделок
    private void init(){
        books.add(new Book("FirstBook","Ivanov",3765));
        books.add(new Book("SecondBook","Petrov",7823));
        books.add(new Book("ThirdBook","Sidorov",1408));
        books.add(new Book("FourthBook","Jones",1043));
        books.add(new Book("FifthBook","Smith",7622));
        books.add(new Book("SixthBook","Blake",9813));
        books.add(new Book("SeventhBook","Rand",5145));
    }

    public BookRepositoryImpl() {
//        books = new ArrayList<>();
//        init();
          books = readBooksRepositoryFromJson();
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    public List<Book> readBooksRepositoryFromJson() {
        Gson gson = new Gson();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/book_repository.json"));
            Type bookListType = new TypeToken<ArrayList<Book>>(){}.getType();
            List<Book> list = gson.fromJson(bufferedReader, bookListType);
            return list;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void writeBookRepositoryToJson() {
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

}

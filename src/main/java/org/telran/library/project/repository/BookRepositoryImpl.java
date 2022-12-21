package org.telran.library.project.repository;

import org.telran.library.project.model.Book;

import java.util.List;

public class BookRepositoryImpl implements BookRepository{

    private List<Book> books;

    private SaveAndRead saveAndRead;
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

    public BookRepositoryImpl(SaveAndRead saveAndRead) {
//        books = new ArrayList<>();
//        init();
        books = saveAndRead.readBooksFromRepository();
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public SaveAndRead getSaveAndRead() {
        return saveAndRead;
    }

    public void setSaveAndRead(SaveAndRead saveAndRead) {
        this.saveAndRead = saveAndRead;
    }
}

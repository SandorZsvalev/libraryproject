package org.telran.library.project.controller;

import org.telran.library.project.model.Book;
import org.telran.library.project.service.BookService;
import org.telran.library.project.service.OrderService;

import java.util.List;
import java.util.Scanner;

public class Controller {
    /*
    Запрашивает у пользователя ввод идентификатора книги что пользователь хочет себе взять(или вернуть)
    После ввода убирает книгу из библиотеки и помещает ее в хранилище к пользователю.
    (или наоборот от пользователя в библиотеку)
    Данный функционал должен быть запущен постоянно, те пользователь постоянно может выбирать различные действия
    и тусовать книги в разные стороны.
    */

    private BookService bookService;
    private OrderService orderService;

    public Controller(BookService bookService, OrderService orderService) {
        this.bookService = bookService;
        this.orderService = orderService;
    }

    public void showAllFromBooksRepository(){
        List<Book> allFromBooksRepository = bookService.getAllFromBooksRepository();
        allFromBooksRepository.forEach(System.out::println);
    }

    public void showAllFromHomeRepository(){
        List<Book> allFromHomeRepository = orderService.getAllFromHomeRepository();
        allFromHomeRepository.forEach(System.out::println);

    }

    public void getFromBooksRepositoryToHomeRepository(Book book){
        bookService.deleteFromBooksRepository(book);
        orderService.addBookToHomeRepository(book);

    }

    public void putToBooksRepositoryFromHomeRepository(Book book){
        orderService.deleteBookFormHomeRepository(book);
        bookService.addToBookRepository(book);
    }

    public void menu(){
        int choise = showTopMenu();
        while (choise!=0){
            switch (choise){
                case 1: {
                    showAllFromBooksRepository();
                    System.out.println("\n");
                    break;
                }
                case 2: {
                    showAllFromHomeRepository();
                    System.out.println("\n");
                    break;
                }
                case 3: {
                    showAllFromBooksRepository();
                    int isbn = showBookMenu();
                    Book book = bookService.findBook(isbn);
                    getFromBooksRepositoryToHomeRepository(book);
                    System.out.println("\n");
                    break;
                }
                case 4: {
                    showAllFromHomeRepository();
                    int isbn = showBookMenu();
                    Book book = orderService.findUsersBook(isbn);
                    putToBooksRepositoryFromHomeRepository(book);
                    System.out.println("\n");
                    break;
                }
            }
            choise = showTopMenu();
       }
    }

    private int showTopMenu(){
        System.out.println("выберите действие: ");
        System.out.println("1 - показать все книги в библиотеке\n" +
                "2 - показать все книги у читателя\n" +
                "3 - выбрать книгу из библиотеки\n" +
                "4 - сдать книгу в библиотеку\n" +
                "0 - вернуться в главное меню\n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Integer.parseInt(String.valueOf(input.charAt(0)));

    }

    private int showBookMenu(){
        System.out.println("\nВведите ISBN номер книги: \n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Integer.parseInt(String.valueOf(input));
    }


}

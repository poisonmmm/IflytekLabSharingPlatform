package com.edu.library.bean;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Library library = new Library();
        List<Book> books = library.getBooks();
        System.out.println(books);
//        books.add(new Book());
    }
}

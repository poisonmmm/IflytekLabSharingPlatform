package com.edu.library.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<Integer, Integer> cap = new HashMap<>();
    private List<Book> books = new ArrayList();

    public Library() {
        init();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void lent(User user, List<Book> books) {
        for (Book book : books) {
            Integer bookCap = cap.get(book.getId());
            cap.put(book.getId(),bookCap-1);
        }
    }

    /**
     * 批量添加图书
     * @param books
     */
    public void addBooks(List<Book> books) {
        books.addAll(books);
        for (Book book:books) {
            Integer bookCap = cap.get(book.getId());
            if (bookCap == null) {
                cap.put(book.getId(), 1);
            } else {
                cap.put(book.getId(), bookCap+1);
            }
        }
    }

    /**
     * 添加图书
     * @param book
     */
    public void addBook(Book book) {
        books.add(book);
        Integer bookCap = cap.get(book.getId());
        cap.put(book.getId(),bookCap+1);
    }

    /**
     * 移除书籍
     * @param book
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * 批量移除书籍
     * @param books
     */
    public void removeBooks(List<Book> books) {
        books.remove(books);
    }

    private void init() {
        Book book = new Book();
        book.setId(1001);
        book.setName("Java");
        book.setAuthor("Tom");

        Book book1 = new Book();
        book1.setId(1002);
        book1.setName("操作系统原理");
        book1.setAuthor("Jack");

        Book book2 = new Book();
        book2.setId(1003);
        book2.setName("数据结构");
        book2.setAuthor("Jerry");

        books.add(book);
        books.add(book1);
        books.add(book2);

        cap.put(book.getId(),6);
        cap.put(book1.getId(),3);
        cap.put(book2.getId(),4);
    }

}

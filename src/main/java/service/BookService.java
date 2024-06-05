package service;

import pojo.Book;
import pojo.User;

import java.util.List;

public interface BookService {
    public List<Book> queryBook(Book book);
    public Book queryBookByIsbn(String isbn);
    public Boolean borrowBook(Book book, User user);
}

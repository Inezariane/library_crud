package com.example.crud_learn.services;

import java.util.*;

import com.example.crud_learn.dto.BookDTO;
import com.example.crud_learn.entities.Book;

public interface BookService {
    List<Book> getAllBooks() throws  Exception;

    Book getBookById(int id) throws  Exception;

    Book createBook(BookDTO book) throws Exception;

    String deleteBookById(int id) throws Exception;

    Book UpdateBookById(int id, BookDTO book) throws Exception;
}

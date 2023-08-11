package com.example.hw3part1.service;

import com.example.hw3part1.entities.Book;
import java.util.List;

public interface BookService {
  List<Book> findAllBooks();
  Book findBookById(int id);
  Book saveBook(Book book);
}

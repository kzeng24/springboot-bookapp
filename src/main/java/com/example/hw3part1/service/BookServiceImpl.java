package com.example.hw3part1.service;

import com.example.hw3part1.entities.Book;
import com.example.hw3part1.repos.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookService")
@Component
@Transactional
public class BookServiceImpl implements BookService {
  @Autowired
  BookRepository bookRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Book> findAllBooks() {
    return (List<Book>) bookRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Book findBookById(int id) {
    return bookRepository.findById(id).get();
  }

  @Override
  @Transactional
  public Book saveBook(Book book) {
    bookRepository.save(book);
    return book;
  }
}

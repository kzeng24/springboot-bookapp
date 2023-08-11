package com.example.hw3part1.entities;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="book")
public class Book {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name="ID")
  private int id;

  @Column(name="CATEGORY_NAME")
  private String category_name;

  @Column(name = "ISBN")
  private String isbn;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "PUBLISHER")
  private String publisher;

  @Column(name = "PRICE")
  private double price;

  public Book() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCategory_name() {
    return category_name;
  }

  public void setCategory_name(String category_name) {
    this.category_name = category_name;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", category_name='" + category_name + '\'' +
        ", isbn='" + isbn + '\'' +
        ", title='" + title + '\'' +
        ", publisher='" + publisher + '\'' +
        ", price=" + price +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return id == book.id && Double.compare(book.price, price) == 0 && category_name
        .equals(book.category_name) && isbn.equals(book.isbn) && title.equals(book.title)
        && publisher
        .equals(book.publisher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category_name, isbn, title, publisher, price);
  }
}

package pl.coderslab.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.annotation.processing.Generated;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @OneToMany(mappedBy = "book")
//    private List<BorrowedBooks> borrowedBooks = new ArrayList<>();
//    @ManyToOne
//    private  PublishingHouse publishingHouse;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Size (min = 10, max = 10)
    private String publishDate;
    @NotBlank
    @Size (min = 13, max = 13)
    private String isbn;
    @NotNull
    private Integer pageNumber;

    private boolean borrowed;


    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
      this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pageNumber=" + pageNumber +
                ", borrowed=" + borrowed +
                '}';
    }
}










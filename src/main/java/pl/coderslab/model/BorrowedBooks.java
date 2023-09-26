package pl.coderslab.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "borrowedBooks")

public class BorrowedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    private Book book;
    @NotNull
    @ManyToOne
    private User user;

//    private LocalDate rentalDate;
//    private LocalDate returnDate;


    public BorrowedBooks () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public LocalDate getRentalDate() {
//        return rentalDate;
//    }
//
//    public void setRentalDate(LocalDate rentalDate) {
//        this.rentalDate = rentalDate;
//    }
//
//    public LocalDate getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(LocalDate returnDate) {
//        this.returnDate = returnDate;
//    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
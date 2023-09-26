package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Book;
import pl.coderslab.model.BorrowedBooks;

public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Long> {
    public BorrowedBooks findByBook (Book book)  ;

 }

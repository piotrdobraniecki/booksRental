package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import pl.coderslab.model.BorrowedBooks;
import pl.coderslab.repository.BorrowedBooksRepository;

@Service
public class BorrowedBooksService {
    @Autowired
    private BorrowedBooksRepository borrowedBooksRepository;

    public BorrowedBooksService(BorrowedBooksRepository borrowedBooksRepository) {
        this.borrowedBooksRepository = borrowedBooksRepository;
    }

    public void saveBorrowedBooks (BorrowedBooks borrowedBooks) {
        borrowedBooksRepository.save(borrowedBooks);
    }
    public void deleteBorrowedBooks (BorrowedBooks borrowedBooks) {
        borrowedBooksRepository.delete(borrowedBooks);
    }

    public BorrowedBooks findByBook (Book book) {
       return borrowedBooksRepository.findByBook(book);
    }


}

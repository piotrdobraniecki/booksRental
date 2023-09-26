package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;


import java.util.List;

@Service

public class BookService {


    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    public List<Book> findAll ()
    {
        return bookRepository.findAll();
    }
    public List<Book> findByAuthorOrTitle (String author, String title) {
        return bookRepository.findBooksByAuthorOrTitle(author, title);

    }

    public  Book findBookById (Long id)
    {
        return bookRepository.findById(id).orElseThrow();
    }

    public void rentBook (Book book) {
        book.setBorrowed(true);
    }
    public void returnBook (Book book) {
        book.setBorrowed(false);
    }
    public void saveBook ( Book book ) {
        bookRepository.save(book);
    }
    public void deleteBook (Book book) {
        bookRepository.delete(book);
    }


}

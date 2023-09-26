package pl.coderslab.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;


import java.util.Optional;

public class BookConverter implements Converter <String, Book> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book convert(String BookId) {
        Long bookIdNumber = Long.valueOf(BookId);
        Optional<Book> bookOptional = bookRepository.findById(bookIdNumber);
        return bookOptional.get();

    }
}

package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BorrowedBooks;
import pl.coderslab.model.User;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.BorrowedBooksRepository;
import pl.coderslab.repository.UserRepository;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BorrowedBooksRepository borrowedBooksRepository;

    @Autowired
    public UserController( BookRepository bookRepository, UserRepository userRepository, BorrowedBooksRepository borrowedBooksRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.borrowedBooksRepository = borrowedBooksRepository;
    }


    @GetMapping("/rent")
    public String showRentForm (Model model) {
        model.addAttribute("AvailableBook", bookRepository.findBooksByBorrowedIsFalse());
        model.addAttribute("borrowedBook", new BorrowedBooks());

        return "/book/rent";

    }
    @PostMapping("/rent")
    public String rentBook (@Valid BorrowedBooks borrowedBooks, BindingResult result) {

        if (result.hasErrors()) {
            return "/book/rent";
        }
        Book book = borrowedBooks.getBook();
        borrowedBooks.getBook().setBorrowed(true);
        bookRepository.save(book);
        borrowedBooks.setBook(book);

        borrowedBooksRepository.save(borrowedBooks);

        return "redirect:/";
    }
    @GetMapping("/return")
    public String showReturnForm (Model model) {
        List<Book> books = bookRepository.findAll();
        List<Book> borrowedBooks = books.stream().filter(Book::getBorrowed).collect(Collectors.toList());
        model.addAttribute("borrowedBooks",new BorrowedBooks());
        model.addAttribute("books",borrowedBooks);

        return "/book/return";

    }
    @PostMapping("/return")
    public String returnBook (@Valid BorrowedBooks borrowedBooks, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/book/return";
        }
        borrowedBooks.getBook().setBorrowed(false);
        bookRepository.save(borrowedBooks.getBook());



        return "redirect:/";
    }




    @ModelAttribute("books")
    public List<Book> getAllBooks () {
        return bookRepository.findAll();
    }
    @ModelAttribute("users")
    public List<User> getAllUsers () {
        return userRepository.findAll();
    }




}

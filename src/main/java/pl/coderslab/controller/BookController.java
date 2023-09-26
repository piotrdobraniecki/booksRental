package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {


    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/showAll")
    public String showAllBooks (Model model) {
        model.addAttribute("books", bookService.findAll());
        return "/book/all";
    }
    @GetMapping("/show")
    public String showBookbyAuthor (Model model, @RequestParam(required = false) String author, String title) {
        model.addAttribute("books", bookService.findByAuthorOrTitle(author, title));
        return "/book/all";
    }
    @GetMapping("/show/bookById/{id}")
    public String showBookbyId (Model model, @PathVariable Long id) {
        model.addAttribute("books", bookService.findBookById(id));
        return "/book/book";

    }
    @GetMapping ("/add")

    public String showAddForm(Model model) {

        model.addAttribute("book", new Book());

        return "/book/add";

    }
    @PostMapping( "/add")

    public String saveAddForm(@Valid Book book, BindingResult result) {

        if (result.hasErrors()) {

            return "/book/add";

        }

        bookService.saveBook(book);

        return "redirect:/";

    }


}

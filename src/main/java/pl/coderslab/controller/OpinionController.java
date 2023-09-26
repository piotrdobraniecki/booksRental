package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Book;
import pl.coderslab.model.Opinion;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.OpinionRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.OpinionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/opinion")
public class OpinionController {

    private final OpinionService opinionService;

    private final OpinionRepository opinionRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public OpinionController(OpinionService opinionService, OpinionRepository opinionRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.opinionService = opinionService;
        this.opinionRepository = opinionRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping ("/add")
    public String showAddForm (Model model) {
        System.out.println("showAddForm");
        model.addAttribute("opinion", new Opinion());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());
        return "opinion/add";
    }
    @PostMapping("/add")
    public String saveAddForm (@Valid  Opinion opinion, BindingResult result,Model model) {

        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            model.addAttribute("books", bookRepository.findAll());
//

            return "opinion/add";
        }
        opinionRepository.save(opinion);
        return "redirect:/";
    }
    @RequestMapping ("/showAll")
    public String showAllOpinion (Model model) {

        model.addAttribute("opinions", opinionRepository.findAll());
        return "opinion/all";
    }


}

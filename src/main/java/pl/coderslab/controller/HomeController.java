package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Book;
import pl.coderslab.model.User;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.UserRepository;
@Controller
public class HomeController {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    @Autowired

    public HomeController(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    @RequestMapping("/")
    public String home () {

        return "home/home";
    }


    @RequestMapping("/start")
    public String start () {
            Book book = new Book();
            book.setTitle("Pan Tadeusz");
            book.setAuthor("Adam Mickiewicz");
            book.setPublishDate("1834-06-28");
            book.setIsbn("9780781800334");
            book.setPageNumber(376);
            book.setBorrowed(false);
            bookRepository.save(book);
            Book book1 = new Book();
            book1.setTitle("Dziady");
            book1.setAuthor("Adam Mickiewicz");
            book1.setPublishDate("1822-06-28");
            book1.setIsbn("9780781804334");
            book1.setPageNumber(316);
            book1.setBorrowed(false);
            bookRepository.save(book1);
            Book book2 = new Book();
            book2.setTitle("Potop");
            book2.setAuthor("Henryk Sienkiewicz");
            book2.setPublishDate("1886-06-28");
            book2.setIsbn("9780781100334");
            book2.setPageNumber(476);
            book2.setBorrowed(false);
            bookRepository.save(book2);
            User user = new User();
            user.setFirstName("Jan");
            user.setLastName("Kowalski");
            user.setEmail("jan@mail.pl");
            user.setPassword("alohomora");
            userRepository.save(user);
            User user1 = new User();
            user1.setFirstName("Tomasz");
            user1.setLastName("Nowak");
            user1.setEmail("tomasz@mail.pl");
            user1.setPassword("alojzyz");
            userRepository.save(user1);
        return "/home/home";
        }
}



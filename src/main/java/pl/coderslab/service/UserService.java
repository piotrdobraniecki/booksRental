package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import pl.coderslab.model.BorrowedBooks;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.model.Book;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User findUser(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }



    public User findUserById (Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    public List<User> findAllUser () {
        return userRepository.findAll();
    }
}




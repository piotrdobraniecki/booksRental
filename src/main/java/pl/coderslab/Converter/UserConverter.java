package pl.coderslab.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.User;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.UserRepository;


import java.util.Optional;

public class UserConverter implements Converter <String, User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(String UserId) {
        Long userIdNumber = Long.valueOf(UserId);
        Optional<User> userOptional = userRepository.findById(userIdNumber);
        return userOptional.get();

    }
}

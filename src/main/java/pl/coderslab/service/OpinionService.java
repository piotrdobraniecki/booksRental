package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import pl.coderslab.model.Opinion;
import pl.coderslab.model.User;
import pl.coderslab.repository.OpinionRepository;


import java.util.List;

@Service
public class OpinionService {

    private final OpinionRepository opinionRepository;
    @Autowired
    public OpinionService(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    public void add (Opinion opinion) {
         opinionRepository.save(opinion);
    }


}


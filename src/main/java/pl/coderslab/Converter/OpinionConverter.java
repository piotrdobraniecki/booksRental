package pl.coderslab.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Book;
import pl.coderslab.model.Opinion;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.OpinionRepository;


import java.util.Optional;

public class OpinionConverter implements Converter <String, Opinion> {

    @Autowired
    private OpinionRepository opinionRepository;

    @Override
    public Opinion convert(String OpinionId) {
        Long opinionIdNumber = Long.valueOf(OpinionId);
        Optional<Opinion> opinionOptional = opinionRepository.findById(opinionIdNumber);
        return opinionOptional.get();

    }
}

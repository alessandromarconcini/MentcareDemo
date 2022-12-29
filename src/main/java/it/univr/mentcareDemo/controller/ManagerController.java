package it.univr.mentcareDemo.controller;
import it.univr.mentcareDemo.model.User;
import it.univr.mentcareDemo.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createUser")
    public User createUser(@RequestParam("name") String name,
                           @RequestParam("surname") String surname,
                           @RequestParam("password") String password,
                           @RequestParam("fiscalCode") String fiscalCode,
                           @RequestParam("birthplace") String birthplace){

        LocalDate now = LocalDate.now();

        User user = new User(name,surname,password,fiscalCode,birthplace,now);
        userRepository.save(user);
        return user;
    }
}

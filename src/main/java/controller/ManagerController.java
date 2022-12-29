package controller;

import model.User;
import model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

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

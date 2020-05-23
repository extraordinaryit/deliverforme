package extraordinaryit.apps.deliverforme.controllers;

import extraordinaryit.apps.deliverforme.entity.User;
import extraordinaryit.apps.deliverforme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<User> getUsers(){

        return null;
    }
}

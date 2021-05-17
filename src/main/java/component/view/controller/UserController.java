package component.view.controller;

import component.service.UserService;
import component.view.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/{login}")
    public ResponseEntity<User> getUser(@PathVariable("login") String login) {
        User user = userService.getUser(login);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
package kr.co.polycube.backendtest.controller;

import kr.co.polycube.backendtest.entity.User;
import kr.co.polycube.backendtest.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody String name) {
        return userService.createUser(name);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    public User updateUser(@PathVariable Long id, @RequestBody String name) {
        return userService.updateUser(id, name);
    }

}

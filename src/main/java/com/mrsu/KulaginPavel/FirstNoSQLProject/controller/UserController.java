package com.mrsu.KulaginPavel.FirstNoSQLProject.controller;

import com.mrsu.KulaginPavel.FirstNoSQLProject.service.UserService;
import com.mrsu.KulaginPavel.FirstNoSQLProject.model.Post;
import com.mrsu.KulaginPavel.FirstNoSQLProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public List<User> create() {
        List<User> users = List.of(
                new User("user1", List.of(new Post("title1", "text1"), new Post("title2", "text2"))),
                new User("User2", List.of())
        );
        return service.addAllUsers(users);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUsersById(@PathVariable String id) {
        Optional<User> person = service.findUserById(id);
        return person.isPresent()
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        HttpStatus status = service.userIsExistsById(id) ? HttpStatus.OK : HttpStatus.CREATED;
        return new ResponseEntity<>(service.updateUser(id, user), status);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        service.deleteUserById(id);
    }

    @DeleteMapping("/users/delete_all")
    public void deleteAll() {
        service.deleteAllUsers();
    }
}

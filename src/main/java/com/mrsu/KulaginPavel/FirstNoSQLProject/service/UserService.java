package com.mrsu.KulaginPavel.FirstNoSQLProject.service;

import com.mrsu.KulaginPavel.FirstNoSQLProject.model.User;
import com.mrsu.KulaginPavel.FirstNoSQLProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> addAllUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    public boolean userIsExistsById(String id) {
        return userRepository.existsById(id);
    }

    public User updateUser(String id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}

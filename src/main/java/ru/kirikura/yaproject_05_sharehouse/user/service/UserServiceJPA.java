package ru.kirikura.yaproject_05_sharehouse.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;
import ru.kirikura.yaproject_05_sharehouse.user.repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceJPA {
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}

package udemy.javaguides.springboot.service;

import udemy.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserId(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}

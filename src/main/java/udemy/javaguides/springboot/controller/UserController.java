package udemy.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udemy.javaguides.springboot.entity.User;
import udemy.javaguides.springboot.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create user RestApi

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
      User savedUser =  userService.createUser(user);
      return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build GET User By Id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
       User user = userService.getUserId(userId);
       return new ResponseEntity<>(user,HttpStatus.OK);

    }

    // Build Get All User REST API
    // http://localhost:8080/api/users

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
       List<User> users= userService.getAllUsers();
       return new ResponseEntity<>(users,HttpStatus.OK);
    }

    // Build Update User Rest API
    // http://localhost:8080/api/users/1

    @PutMapping("{id}")
    public  ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                            @RequestBody User user){
        user.setId(userId);
      User updatedUser =  userService.updateUser(user);
      return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }

    // Build Delete User REST API
      @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!",HttpStatus.OK);
    }
}

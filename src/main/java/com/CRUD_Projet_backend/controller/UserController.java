package com.CRUD_Projet_backend.controller;

import com.CRUD_Projet_backend.entity.Service;
import com.CRUD_Projet_backend.entity.User;
import com.CRUD_Projet_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    //
    private final UserService userService;
    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.postUser(user);
    }
    //
    @GetMapping("/")
    public List<User> readAllUsers(){
        return userService.getAllUsers();
    }
    //
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    //
    @GetMapping("/detail/{id}")
    public ResponseEntity<User> showUserById(@PathVariable Long id){
        User detailUser = userService.getOneUserById(id);
        if(detailUser==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(detailUser);
    }
    //
    @PutMapping("/update/{id}")
    public ResponseEntity<User> getUserEditById(@PathVariable Long id, @RequestBody User user){
        User dataUpdate = userService.updateUser(id, user);
        if(dataUpdate==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(dataUpdate);
    }
//

}

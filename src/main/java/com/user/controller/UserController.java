package com.user.controller;

import com.user.dto.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable(value = "idUser") Long idUser){
        return ResponseEntity.ok().body(userService.updateUser(user, idUser));
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<?> getUser(@PathVariable(value = "idUser") Long idUser){
        return ResponseEntity.ok().body(userService.getUser(idUser));
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "idUser") Long idUser){
        userService.deleteUser(idUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok().body(userService.getAllUser());
    }


}

package com.yaazhtech.bankmanagement.controller;

import com.yaazhtech.bankmanagement.data.PupilUser;
import com.yaazhtech.bankmanagement.model.request.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserInterface {

    @PostMapping("/save")
    String createUser(@RequestBody UserRequest userRequest);

    @GetMapping("/all")
    List<PupilUser> getAllUsers();

    @GetMapping("/{id}")
    PupilUser getUserById(@PathVariable Long id);

    @PutMapping("/{id}")
    PupilUser updateUser(@PathVariable Long id, @RequestBody UserRequest updatedUser);

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable Long id);
}

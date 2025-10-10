package com.yaazhtech.bankmanagement.controller;

import com.yaazhtech.bankmanagement.data.PupilUser;
import com.yaazhtech.bankmanagement.model.request.LoginRequest;
import com.yaazhtech.bankmanagement.model.request.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserInterface {

    @PostMapping("/save")
        // Defines a POST endpoint at /save for creating a new user
    String createUser(@RequestBody UserRequest userRequest);
    // Method to create a new user; @RequestBody maps JSON from Postman to a UserRequest object

    @GetMapping("/all")
        // Defines a GET endpoint at /all to fetch all users
    List<PupilUser> getAllUsers();
    // Method returns a list of all PupilUser objects from the database

    @GetMapping("/{id}")
        // Defines a GET endpoint at /{id} to fetch a single user by their ID
    PupilUser getUserById(@PathVariable Long id);
    // Method takes the ID from the URL and returns the matching PupilUser, or null if not found

    @PutMapping("/{id}")
        // Defines a PUT endpoint at /{id} to update an existing user by ID
    PupilUser updateUser(@PathVariable Long id, @RequestBody UserRequest updatedUser);
    // Method takes ID from the URL and updated user data from JSON; updates the user in DB and returns the updated object

    @DeleteMapping("/{id}")
        // Defines a DELETE endpoint at /{id} to remove a user by ID
    String deleteUser(@PathVariable Long id);
    // Method checks if the user exists; deletes if present and returns a confirmation message, otherwise returns "User not found"
    @PostMapping("/login")
    String login(@RequestBody LoginRequest loginRequest);

}

package com.yaazhtech.bankmanagement.controller;

import com.yaazhtech.bankmanagement.data.PupilUser;
import com.yaazhtech.bankmanagement.model.request.UserRequest;
import com.yaazhtech.bankmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user/detail")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Manual logger (instead of @Slf4j)
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    // ---------------- CREATE USER ----------------
    @PostMapping("/save")
    public String createUser(@RequestBody UserRequest userRequest) {
        PupilUser pupilUser = new PupilUser();

        pupilUser.setName(userRequest.getName());
        pupilUser.setEmail(userRequest.getEmail());
        pupilUser.setPhone(userRequest.getPhone());
        pupilUser.setAccountNumber(userRequest.getAccountNumber());
        pupilUser.setPassword(userRequest.getPassword());
        pupilUser.setRole("USER"); // default role
        pupilUser.setUserName(userRequest.getName()); // optional

        userRepository.save(pupilUser);
        logger.info("User saved successfully: " + pupilUser.getEmail());

        return "User data has been saved successfully";
    }

    // ---------------- GET ALL USERS ----------------
    @GetMapping("/all")
    public List<PupilUser> getAllUsers() {
        logger.info("Fetching all users from database");
        return userRepository.findAll();
    }

    // ---------------- GET USER BY ID ----------------
    @GetMapping("/{id}")
    public PupilUser getUserById(@PathVariable Long id) {
        logger.info("Fetching user with ID: " + id);
        return userRepository.findById(id).orElse(null);
    }

    // ---------------- DELETE USER ----------------
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            logger.info("User deleted successfully with ID: " + id);
            return "User deleted successfully";
        } else {
            logger.warning("Attempted to delete non-existing user with ID: " + id);
            return "User not found";
        }
    }

    // ---------------- UPDATE USER ----------------
    @PutMapping("/{id}")
    public PupilUser updateUser(@PathVariable Long id, @RequestBody PupilUser updatedUser) {
        logger.info("Updating user with ID: " + id);
        PupilUser existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setAccountNumber(updatedUser.getAccountNumber());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setRole(updatedUser.getRole());
            existingUser.setUserName(updatedUser.getUserName());

            logger.info("User updated successfully: " + existingUser.getEmail());
            return userRepository.save(existingUser);
        } else {
            logger.warning("User not found for update with ID: " + id);
            return null;
        }
    }
}

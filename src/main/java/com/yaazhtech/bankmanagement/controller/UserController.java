package com.yaazhtech.bankmanagement.controller;

import com.yaazhtech.bankmanagement.data.PupilUser;
import com.yaazhtech.bankmanagement.model.request.UserRequest;
import com.yaazhtech.bankmanagement.model.request.LoginRequest;

import com.yaazhtech.bankmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/detail")
public class UserController implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(@RequestBody UserRequest userRequest)
    // Spring created this object automatically 👇
    // UserRequest request = {name="Preethi", email="preethi@gmail.com", ...}
    //@RequestBody → “Spring, please make this object from the client’s JSON.”
    {
        // You create this manually 👇 to save in DB
        PupilUser pupilUser = new PupilUser();

        pupilUser.setPassword(userRequest.getPassword());
        pupilUser.setName(userRequest.getName());
        pupilUser.setEmail(userRequest.getEmail());
        pupilUser.setUserName(userRequest.getUserName());
        pupilUser.setPhone(userRequest.getPhone());
        pupilUser.setRole(userRequest.getRole());
        pupilUser.setAccountNumber(userRequest.getAccountNumber());
        pupilUser.setOtpData(userRequest.getOtpData());

        userRepository.save(pupilUser);
        //pupilUser is a Java object of type PupilUser.
        //It holds the user data you want to save
        //Object mapped to SQL and persisted in DB
        return "User saved successfully!";
    }

    @Override
    //You're using the @Override keyword because your controller class implements (or extends) an interface that already defines those methods —
    // and that’s why you don’t see @PostMapping, @GetMapping, @PutMapping, etc. directly inside your controller.
    public List<PupilUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    //UserController overrides the methods from the UserApi interface using the @Override annotation.
    public PupilUser getUserById(@PathVariable Long id)
    //The id comes from the URL. Example: GET /user/1 → id = 1
    {
        Optional<PupilUser> userOpt = userRepository.findById(id);
        //Returns Optional<PupilUser> because the user may or may not exist.
        return userOpt.orElse(null);
    }

    @Override
    public PupilUser updateUser(@PathVariable Long id, @RequestBody UserRequest updatedUser)
    //Take the JSON body sent from the client (Postman)
    // and automatically convert it into a Java object of type UserRequest
    {
        Optional<PupilUser> existingOpt = userRepository.findById(id);//fetch the existing user
        if (existingOpt.isPresent())//check if user exists
             {
            PupilUser user = existingOpt.get();//retrieve the user object
            user.setPassword(updatedUser.getPassword());//update all fields of the user
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setUserName(updatedUser.getUserName());
            user.setPhone(updatedUser.getPhone());
            user.setRole(updatedUser.getRole());
            user.setAccountNumber(updatedUser.getAccountNumber());
            user.setOtpData(updatedUser.getOtpData());

            return userRepository.save(user);//Spring Data JPA persists changes in the DB.
                // If the object has an ID, JPA performs UPDATE, not INSERT.
        }
        return null;
        //existingOpt.isPresent() → checks if the user exists in the database.
        //If true:
        //The user exists, you update the fields, save it using repository.save(user), and return the updated user object.
        //If false:
        //The user does not exist in the database.
        //There’s nothing to update, so you return null;
    }

    @Override
    public String deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully!";
        }
        return "User not found!";
    }
        // Example login method
        // ------------------- LOGIN USER -------------------
        @Override
        public String login(@RequestBody LoginRequest loginRequest) {
            PupilUser user = userRepository.findByUserName(loginRequest.getUserName());
            if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
                return "Login successful for user: " + user.getUserName();
            }
            return "Invalid username or password";
        }

    }


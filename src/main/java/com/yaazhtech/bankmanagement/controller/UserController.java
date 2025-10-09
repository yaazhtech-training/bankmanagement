package com.yaazhtech.bankmanagement.controller;

import com.yaazhtech.bankmanagement.data.PupilUser;
import com.yaazhtech.bankmanagement.model.request.UserRequest;
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
    public String createUser(@RequestBody UserRequest userRequest) {
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
        return "User saved successfully!";
    }

    @Override
    public List<PupilUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public PupilUser getUserById(@PathVariable Long id) {
        Optional<PupilUser> userOpt = userRepository.findById(id);
        return userOpt.orElse(null);
    }

    @Override
    public PupilUser updateUser(@PathVariable Long id, @RequestBody UserRequest updatedUser) {
        Optional<PupilUser> existingOpt = userRepository.findById(id);
        if (existingOpt.isPresent()) {
            PupilUser user = existingOpt.get();
            user.setPassword(updatedUser.getPassword());
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setUserName(updatedUser.getUserName());
            user.setPhone(updatedUser.getPhone());
            user.setRole(updatedUser.getRole());
            user.setAccountNumber(updatedUser.getAccountNumber());
            user.setOtpData(updatedUser.getOtpData());

            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public String deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully!";
        }
        return "User not found!";
    }
}

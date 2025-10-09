package com.yaazhtech.bankmanagement.controller;

import com.yaazhtech.bankmanagement.data.PupilUser;
import com.yaazhtech.bankmanagement.model.request.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
BankInterface defines the REST endpoints for bank management operations.
It acts as a blueprint (contract) for the controller class to implement.
Each method corresponds to an API operation for managing bank accounts.
*/

public interface UserInterface {

    // Create a new bank account
    @PostMapping("/createAccount")
    String createAccount(@RequestBody UserRequest userRequest);

    // Get details of all bank accounts
    @GetMapping("/allAccounts")
    List<PupilUser> getAllAccounts();

    // Get details of a specific account by ID
    @GetMapping("/{accountId}")
    PupilUser getAccountById(@PathVariable Long accountId);

    // Delete an account by ID
    @DeleteMapping("/{accountId}")
    void deleteAccount(@PathVariable Long accountId);

    // Update account details
    @PutMapping("/{accountId}")
    PupilUser updateAccount(@PathVariable Long accountId, @RequestBody PupilUser updatedAccount);
}

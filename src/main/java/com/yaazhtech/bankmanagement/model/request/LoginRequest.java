package com.yaazhtech.bankmanagement.model.request;

public class LoginRequest {

    private String userName;
    private String password;

    // Default constructor
    public LoginRequest() { }

    // Getters and setters
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

package com.yaazhtech.bankmanagement.model.request;

public class UserRequest {

    private String password;
    private String name;
    private String email;
    private String userName;
    private String phone;
    private String role;
    private String accountNumber;
    private String otpData;

    // Getters and Setters
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getOtpData() { return otpData; }
    public void setOtpData(String otpData) { this.otpData = otpData; }
}

package com.yaazhtech.bankmanagement.data;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_users")
public class PupilUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(unique = true)
    private String phone;

    @Column(nullable = false)
    private String role;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "otp_data")
    private String otpData;

    public PupilUser() {}

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

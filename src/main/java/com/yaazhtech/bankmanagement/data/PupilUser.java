package com.yaazhtech.bankmanagement.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

// Mark this class as a JPA entity (table in DB)
@Entity

//@NoArgsConstructor
@AllArgsConstructor
// Optional: specify custom table name
@Table(name = "bank_users")
public class PupilUser {

    // Primary key of the table
    @Id
    // Auto-generate ID values for H2 database
    @GeneratedValue(strategy = GenerationType.AUTO)//“Automatically generate the primary key value for this entity.”
    private Long id;

    // Password column, cannot be null
    @Column(nullable = false)
    private String password;

    // Full name of the user
    @Column(nullable = false)//this column cannot have null values in the database.
    private String name;

    // Email must be unique
    @Column(nullable = false, unique = true)
    private String email;

    // Username column
    @Column(name = "user_name", nullable = false)
    private String userName;

    // Phone number column
    @Column(name = "phone_number", unique = true)
    private String phone;

    // Role of the user (ADMIN, USER, etc.)
    @Column(nullable = false)
    private String role;

    // Bank account number, unique
    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    // OTP data for verification
    @Column(name = "otp_data")
    private String otpData;

    // Is the account active?

    // Default constructor required by JPA
    public PupilUser() { }

    // Parameterized constructor
    public PupilUser(Long id, String password, String name, String email, String userName, String phone, String role, String accountNumber, String otpData, boolean active) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.phone = phone;
        this.role = role;
        this.accountNumber = accountNumber;
        this.otpData = otpData;

    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOtpData() {
        return otpData;
    }

    public void setOtpData(String otpData) {
        this.otpData = otpData;
    }
}

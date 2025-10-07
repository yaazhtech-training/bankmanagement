package com.yaazhtech.bankmanagement.model.request;


import lombok.Data;


/*Getters (to read data)
Constructor: Used to create an object and initialize its values.
Setters (to modify data)
Getter: Used to read or get the value of a variable.
Setters (to modify data)
Setter: Used to modify or set the value of a variable.
 */
@Data

public class UserRequest {


    private String name;
    private String email;
    private String phone;
    private String accountNumber;
    private String password;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRequest(String name, String email, String phone, String accountNumber, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.accountNumber = accountNumber;
        this.password = password;
    }
}

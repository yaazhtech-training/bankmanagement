package com.yaazhtech.bankmanagement.model.response;

public class TokenResponse {
    private String message;
    private String token;

    public TokenResponse() {
    }

    public TokenResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
//User sends login credentials (username, password).

//Backend verifies them.
//
//Backend creates a JWT Token or session token.
//
//Backend sends a response that looks like this
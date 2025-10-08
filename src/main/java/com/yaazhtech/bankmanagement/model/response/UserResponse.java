package com.yaazhtech.bankmanagement.model.response;

import com.yaazhtech.bankmanagement.data.PupilUser;



public class UserResponse {
    private String message;
    private PupilUser user;

    public UserResponse(String message, PupilUser user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public PupilUser getUser() {
        return user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(PupilUser user) {
        this.user = user;
    }
}

//Sends message + user data
package com.modestack.assignment.model;

public class User {

    private String username;
    private String password;
    private String email;
    private String address;
    private String access_token;

    public String getAccess_token() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

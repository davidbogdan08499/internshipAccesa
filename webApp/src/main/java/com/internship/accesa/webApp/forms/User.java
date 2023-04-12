package com.internship.accesa.webApp.forms;


public class User extends RegisterForm {

    private int id;
    private String username;
    private String password;

    private String mail;

    public User() {

    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.mail = email;
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
        return mail;
    }

    public void setEmail(String email) {
        this.mail = email;
    }
}

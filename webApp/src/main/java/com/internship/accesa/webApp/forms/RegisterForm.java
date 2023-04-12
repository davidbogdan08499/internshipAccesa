package com.internship.accesa.webApp.forms;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * Form for user registration
 */
@Component
public class RegisterForm {

    @NotBlank(message = "is required")
    private String username;

    @NotBlank(message = "is required")
    private String password;

    private String confirmPassword;
    private String mail;

    private int tokens = 50;

    public RegisterForm() {

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", mail='" + mail + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}

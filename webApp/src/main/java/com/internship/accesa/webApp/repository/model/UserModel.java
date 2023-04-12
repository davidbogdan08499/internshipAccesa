package com.internship.accesa.webApp.repository.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "users")
public class UserModel {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String username;
    private String password;

    @Column(name = "confirmp")
    private String confirmPassword;
    private String mail;
    private int tokens;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<QuestModel> questModelSet;


    @Column(name="badge")
    private String badge;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public List<QuestModel> getQuestDataSet() {
        return questModelSet;
    }

    public void setQuestDataSet(List<QuestModel> questModelSet) {
        this.questModelSet = questModelSet;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", mail='" + mail + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}

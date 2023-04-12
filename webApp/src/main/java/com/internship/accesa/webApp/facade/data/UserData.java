package com.internship.accesa.webApp.facade.data;

import com.internship.accesa.webApp.repository.model.QuestModel;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;


@Component
public class UserData {

    private int Id;
    private String username;
    private String password;

    private String mail;
    private int tokens;


    private List<QuestModel> questModelSet;


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
                ", mail='" + mail + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}

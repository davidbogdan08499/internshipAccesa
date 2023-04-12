package com.internship.accesa.webApp.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quests")
public class QuestModel {

    @Id
    private String id;
    private String question;

    @Column(name = "answer1")
    private String answerOne;
    @Column(name = "answer2")
    private String answerTwo;
    @Column(name = "answer3")
    private String answerThree;

    @Column(name = "idcorrect")
    private int idCorrectAnswer;

    @ManyToOne
    @JoinColumn(name = "user",nullable = false)
    private UserModel user;

    public QuestModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    public int getIdCorrectAnswer() {
        return idCorrectAnswer;
    }

    public void setIdCorrectAnswer(int idCorrectAnswer) {
        this.idCorrectAnswer = idCorrectAnswer;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}

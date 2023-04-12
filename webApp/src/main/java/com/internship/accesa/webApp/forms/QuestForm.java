package com.internship.accesa.webApp.forms;

import org.springframework.stereotype.Component;

/**
 * Form for creating quests
 */
@Component
public class QuestForm {
    private String id;
    private String question;

    private String answerOne;

    private String answerTwo;

    private String answerThree;

    private int idCorrectAnswer;

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

    @Override
    public String toString() {
        return "CreateQuestForm{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answerOne='" + answerOne + '\'' +
                ", answerTwo='" + answerTwo + '\'' +
                ", answerThree='" + answerThree + '\'' +
                ", idCorrectAnswer=" + idCorrectAnswer +
                '}';
    }
}

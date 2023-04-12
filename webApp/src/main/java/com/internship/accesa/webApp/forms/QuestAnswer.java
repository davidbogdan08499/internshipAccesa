package com.internship.accesa.webApp.forms;

import org.springframework.stereotype.Component;

@Component
public class QuestAnswer {

    private int questAnswerValue;

    public int getQuestAnswerValue() {
        return questAnswerValue;
    }

    public void setQuestAnswerValue(int questAnswerValue) {
        this.questAnswerValue = questAnswerValue;
    }
}

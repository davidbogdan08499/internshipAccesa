package com.internship.accesa.webApp.facade.impl;

import com.internship.accesa.webApp.constants.ConstantsVariables;
import com.internship.accesa.webApp.facade.QuestFacade;
import com.internship.accesa.webApp.facade.data.QuestData;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.forms.BADGES;
import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.service.QuestService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultQuestFacade implements QuestFacade {

    private final QuestService questService;

    public DefaultQuestFacade(QuestService questService) {
        this.questService = questService;
    }


    @Override
    public void createQuest(QuestData questData) {
        getQuestService().createQuest(questService.getQuestModelFromQuestData(questData));
    }


    @Override
    public List<QuestModel> getQuestsByCriteria(UserData currentUser) {
        return questService.getQuestsById(currentUser);
    }


    @Override
    public QuestModel getChosenQuestById(String id) {
        return questService.getChosenQuestById(id);
    }


    public QuestService getQuestService() {
        return questService;
    }

    @Override
    public boolean getStatusOFCreateQuestButton(UserData userData) {
        if(userData.getBadge().toString().equals("ADMIN")) return true;
        return userData.getTokens() >= ConstantsVariables.MINIMUM_TOKENS_FOR_CREATING_REQUEST;
    }
}

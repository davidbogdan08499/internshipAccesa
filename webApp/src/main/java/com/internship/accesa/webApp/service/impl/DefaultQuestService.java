package com.internship.accesa.webApp.service.impl;

import com.internship.accesa.webApp.exception.QuestCreationServiceException;
import com.internship.accesa.webApp.facade.data.QuestData;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.repository.QuestDAO;
import com.internship.accesa.webApp.service.QuestService;
import com.internship.accesa.webApp.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultQuestService implements QuestService {

    private QuestDAO questDAO;
    private UserService userService;

    public DefaultQuestService(QuestDAO questDAO, UserService userService) {
        this.questDAO = questDAO;
        this.userService = userService;
    }

    @Override
    public void createQuest(QuestModel questModel) {
        boolean isQuestSaved = getQuestDAO().saveQuest(questModel);
        if (!isQuestSaved) {
            throw new QuestCreationServiceException("The quest hasn't been created!");
        }
    }

    @Override
    public List<QuestModel> getQuestsById(UserData currentUser) {

        return questDAO.getQuestsByCriteria(userService.getUserModelFromUserData(currentUser));
    }

    @Override
    public QuestModel getChosenQuestById(String id) {
        return questDAO.getChosenQuestById(id);
    }


    public QuestDAO getQuestDAO() {
        return questDAO;
    }

    @Override
    public QuestModel getQuestModelFromQuestData(QuestData questData) {
        QuestModel questModel = new QuestModel();
        questModel.setId(questData.getId());
        questModel.setQuestion(questData.getQuestion());
        questModel.setAnswerOne(questData.getAnswerOne());
        questModel.setAnswerTwo(questData.getAnswerTwo());
        questModel.setAnswerThree(questData.getAnswerThree());
        questModel.setIdCorrectAnswer(questData.getIdCorrectAnswer());
        questModel.setUser(userService.getUserModelFromUserData(questData.getUser()));

        return questModel;
    }

    @Override
    public QuestData getQuestDataFromQuestModel(QuestModel questModel) {
        QuestData questData = new QuestData();
        questData.setId(questModel.getId());
        questData.setQuestion(questModel.getQuestion());
        questData.setAnswerOne(questModel.getAnswerOne());
        questData.setAnswerTwo(questModel.getAnswerOne());
        questData.setAnswerThree(questModel.getAnswerThree());
        questData.setIdCorrectAnswer(questModel.getIdCorrectAnswer());
        questData.setUser(userService.getUserDataFromUserModel(questModel.getUser()));

        return questData;
    }

    @Override
    public QuestService getQuestService() {
        return null;
    }

}

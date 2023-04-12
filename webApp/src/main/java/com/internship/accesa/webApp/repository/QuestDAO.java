package com.internship.accesa.webApp.repository;

import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.repository.model.UserModel;

import java.util.List;

/**
 * Interface for working with quests and database
 */
public interface QuestDAO {
    /**
     * Save a quest
     * @param questModel an object of type{@link UserModel}
     *                   that contains data of the quest that we want to upload
     * @return a boolean that check if the operation was a success or not
     */
    boolean saveQuest(QuestModel questModel);

    /**
     * Get a list of quests from database after a criteria
     * @param currentUser an object of type {@link UserModel} that contains data about the searched user
     * @return a list of type {@link UserModel} that contains all the quests after the criteria filter
     */
    List<QuestModel> getQuestsByCriteria(UserModel currentUser);

    /**
     * Get a specific quest by id
     * @param id an String that contains the Id of the searched quest
     * @return an object of type{@link QuestModel}
     */
    QuestModel getChosenQuestById(String id);


}

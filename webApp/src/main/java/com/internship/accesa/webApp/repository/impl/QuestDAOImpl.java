package com.internship.accesa.webApp.repository.impl;

import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.forms.BADGES;
import com.internship.accesa.webApp.repository.QuestDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class QuestDAOImpl implements QuestDAO {

    private EntityManager entityManager;

    public QuestDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public boolean saveQuest(QuestModel questModel) {
        entityManager.persist(questModel);
        return entityManager.contains(questModel);
    }

    @Override
    public List<QuestModel> getQuestsByCriteria(UserModel currentUser) {
        TypedQuery<QuestModel> typedQuery = entityManager.createQuery(
                "FROM QuestModel WHERE user.Id != :userid AND user.badge IN (:badgesList)", QuestModel.class
        );
        typedQuery.setParameter("userid", currentUser.getId());
        List<String> filteredBadges = Arrays.stream(BADGES.values())
                .filter(badge -> badge.ordinal() <= BADGES.valueOf(currentUser.getBadge()).ordinal())
                .map(Enum::toString)
                .toList();
        typedQuery.setParameter("badgesList", filteredBadges);
        return typedQuery.getResultList();
    }

    @Override
    public QuestModel getChosenQuestById(String idQuest) {
        TypedQuery<QuestModel> typedQuery = entityManager.createQuery(
                "FROM QuestModel WHERE id = :questid", QuestModel.class
        );
        typedQuery.setParameter("questid", idQuest);
        //todo add if if list is empty
        return typedQuery.getResultList().get(0);
    }

}

package com.internship.accesa.webApp.repository.impl;

import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.forms.BADGES;
import com.internship.accesa.webApp.repository.UserDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.query.sqm.UnknownEntityException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default implementation of {@link UserDAO}.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public boolean saveUser(UserModel userModel) {
        entityManager.persist(userModel);
        return entityManager.contains(userModel);
    }

    @Override
    @Transactional
    public void modifyTokensUser(int tokens, int id) {
        Query query = entityManager.createQuery("UPDATE UserModel u set u.tokens=u.tokens +:tokens where u.Id= :id");
        query.setParameter("tokens", tokens);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<UserModel> getCurrentUser(int id) {
        TypedQuery<UserModel> typedQuery = entityManager.createQuery(
                "FROM UserModel WHERE id= :givenid", UserModel.class);
        typedQuery.setParameter("givenid", id);
        return typedQuery.getResultList();
    }

    @Override
    public List<UserModel> getUserByUsername(String username) {
        TypedQuery<UserModel> typedQuery = entityManager.createQuery(
                "FROM UserModel WHERE username= :givenUsername", UserModel.class);

        typedQuery.setParameter("givenUsername", username);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void modifyBadgeUser(UserModel userModel) {
        String badgeToChange;
        if (userModel.getTokens() < 80) {
            userModel.setBadge(BADGES.ENTHUSIAST.toString());
        } else if (userModel.getTokens() < 95) {
            userModel.setBadge(BADGES.DISCOVERER.toString());
        } else if (userModel.getTokens() < 115) {
            userModel.setBadge(BADGES.INFLUENCER.toString());
        } else if (userModel.getTokens() >= 120) {
            userModel.setBadge(BADGES.CHAMPION.toString());
        }
        Query query = entityManager.createQuery("UPDATE UserModel u set u.badge=:newBadge where u.Id= :id");
        query.setParameter("newBadge", userModel.getBadge().toString());
        query.setParameter("id", userModel.getId());
        query.executeUpdate();

    }

    @Override
    public int getRankingPositionOfUser(int id) {
        int searchedPosition = 0;
        TypedQuery<UserModel> typedQuery = entityManager.createQuery(
                " FROM UserModel ", UserModel.class);
        List<UserModel> arrayList = new ArrayList<>();
        arrayList = typedQuery.getResultList();
        arrayList = (ArrayList<UserModel>) arrayList.stream().sorted(Comparator.comparing(UserModel::getTokens).reversed()).collect(Collectors.toList());

        for (UserModel u : arrayList) {
            searchedPosition++;
            if (u.getId() == id) break;
        }
        return searchedPosition;
    }


}

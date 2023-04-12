package com.internship.accesa.webApp.service.impl;

import com.internship.accesa.webApp.repository.UserDAO;
import com.internship.accesa.webApp.repository.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DefaultUserServiceTest {
    private static final int ID=5;
    private static final int TOKENS=30;
    @Mock
    private UserDAO userDAO;

    @Mock
    private UserModel userModel;


    @InjectMocks
    private DefaultUserService userService;

    @Test
    public void testModifyToknesUser(){
        userDAO.modifyTokensUser(TOKENS,ID);
    }

    @Test
    public void testGetCurrentUser(){
        userDAO.getCurrentUser(ID);
    }

    @Test
    public void testModifyUserBadge(){
        userDAO.modifyBadgeUser(userModel);
    }

    @Test
    public void testGetRankingPositionOfUser(){
        userDAO.getRankingPositionOfUser(ID);
    }

}

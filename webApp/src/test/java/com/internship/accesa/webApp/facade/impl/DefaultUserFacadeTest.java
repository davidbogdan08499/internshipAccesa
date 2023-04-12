package com.internship.accesa.webApp.facade.impl;

import com.internship.accesa.webApp.exception.UserNotAvailableServiceException;
import com.internship.accesa.webApp.facade.exception.FacadeException;
import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.service.UserService;
import jakarta.servlet.http.PushBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DefaultUserFacadeTest {
    private static final String USERNAME = "bogdan";
    @Mock
    private UserService userService;

    @InjectMocks
    private DefaultUserFacade userFacade;

    @Mock
    private UserModel userModel;


    private int tokens;


    private int id;

    @Before
    public void setUp() throws UserNotAvailableServiceException {
        when(userModel.getUsername()).thenReturn(USERNAME);
        when(userService.getUserByUsername(USERNAME)).thenReturn(userModel);
    }

    @Test(expected = FacadeException.class)
    public void testCreateUserWhenUserExists() {
        userFacade.createUser(userModel);
    }

    @Test()
    public void testCreateUserWhenUserDoesNotExists() throws UserNotAvailableServiceException {
        when(userService.getUserByUsername(USERNAME)).thenThrow(UserNotAvailableServiceException.class);

        userFacade.createUser(userModel);

        verify(userService, times(1)).createUser(userModel);
    }

    @Test
    public void testModifyTokensUser() {
        userService.modifyToknesUser(tokens, id);

        verify(userService,times(1)).modifyToknesUser(tokens,id);
    }

    @Test
    public void testModifyBadgeUser(){
     userService.modifyUserBadge(userModel);

     verify(userService,times(1)).modifyUserBadge(userModel);
    }

    @Test
    public void testGetUserService(){
        Assertions.assertEquals(userFacade.getUserService(),userService);
    }



}

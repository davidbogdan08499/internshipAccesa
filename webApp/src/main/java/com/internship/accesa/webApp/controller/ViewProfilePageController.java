package com.internship.accesa.webApp.controller;

import com.internship.accesa.webApp.facade.UserFacade;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/viewProfile")
public class ViewProfilePageController {

    public static String VIEW_PROFILE_PAGE = "viewProfilePage";
    private static final String HOME_PAGE = "home";
    private UserFacade userFacade;

    public ViewProfilePageController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping
    public String getInfo(HttpServletRequest httpServletRequest, Model model) {
        if (httpServletRequest.getSession().getAttribute("user") == null) {
            return HOME_PAGE;
        }
        UserData userData = (UserData) httpServletRequest.getSession().getAttribute("user");
        if (userData != null) {
            userData.setTokens(userFacade.getCurrentUser(userData.getId()).get(0).getTokens());
            model.addAttribute("userData", userData);
            int rankOFCurrentUser = userFacade.getRankingPositionofUser(userData.getId());
            model.addAttribute("rankOfUser", rankOFCurrentUser);

            return VIEW_PROFILE_PAGE;
        }
        return null;
    }
}

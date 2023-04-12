package com.internship.accesa.webApp.controller;


import com.internship.accesa.webApp.constants.ConstantsVariables;
import com.internship.accesa.webApp.facade.QuestFacade;
import com.internship.accesa.webApp.facade.UserFacade;
import com.internship.accesa.webApp.facade.data.QuestData;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.forms.BADGES;
import com.internship.accesa.webApp.repository.model.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageAppController {

    private static final String MAIN_PAGE_APP = "mainPageApp";
    private static final String HOME_PAGE = "home";

    private UserFacade userFacade;
    private QuestFacade questFacade;

    public MainPageAppController(UserFacade userFacade, QuestFacade questFacade) {
        this.questFacade = questFacade;
        this.userFacade = userFacade;
    }

    @GetMapping()
    public String getMainPage(HttpServletRequest httpServletRequest, Model model) {

        if (httpServletRequest.getSession().getAttribute("user") == null) {
            return HOME_PAGE;
        }
        UserData currentUser = (UserData) httpServletRequest.getSession().getAttribute("user");
        userFacade.modifyBadgeUser(userFacade.getUserService().getUserModelFromUserData(currentUser));
        model.addAttribute("userData", currentUser);
        model.addAttribute("constantValue", ConstantsVariables.MINIMUM_TOKENS_FOR_CREATING_REQUEST);
        model.addAttribute("conditionCreateButton", questFacade.getStatusOFCreateQuestButton(currentUser));
        return MAIN_PAGE_APP;
    }


}

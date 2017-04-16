package org.demo.controller;

import org.demo.model.UserInfo;
import org.demo.service.IFindUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by jzchen on 2017/2/3 0003.
 */
@Controller
public class LoginController {

    IFindUserService findUserService = null;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "loginPage";
    }

    @RequestMapping(value = "/user/{userID}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable String userID, ModelMap modelMap) {
        UserInfo prepareUser = (UserInfo)modelMap.get("prepareUser");
        System.out.println(prepareUser.getUsername());
        UserInfo user = findUserService.findUser(Integer.valueOf(userID));
        ModelAndView model = new ModelAndView();
        model.setViewName("userDetail");
        model.addObject("user", user);
        return model;
    }

    @ModelAttribute(value = "prepareUser")
    public UserInfo prepare() {
        UserInfo user = new UserInfo();
        user.setUsername("prepareUser");
        return user;
    }

    public IFindUserService getFindUserService() {
        return findUserService;
    }

    @Resource
    public void setFindUserService(IFindUserService findUserService) {
        this.findUserService = findUserService;
    }
}

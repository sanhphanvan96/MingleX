package com.ksv.minglex.controller;

import com.ksv.minglex.setting.SecuritySetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @Autowired
    SecuritySetting securitySetting;

    private ModelAndView modelAndView;

    @RequestMapping(value = "/configuration", method = RequestMethod.GET)
    public ModelAndView configuration() {
        modelAndView = new ModelAndView();

        modelAndView.addObject(securitySetting);
        modelAndView.setViewName("configuration");
        return modelAndView;
    }
}

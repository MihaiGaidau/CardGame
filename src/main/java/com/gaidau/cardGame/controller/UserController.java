package com.gaidau.cardGame.controller;

import com.gaidau.cardGame.bean.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String logIn(Model model) {

        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {

        return "signup";
    }

//    @PostMapping("/home")
//    public String processForm(@ModelAttribute(value = "user") User user) {
//        log.info("logmisa: " + user.toString());
//
//        return "adminhome";
//    }
    @PostMapping("home")
    public ModelAndView userHome(@ModelAttribute User user) {


        ModelAndView model = new ModelAndView();

        model.addObject("username", user.getUsername());

        model.setViewName("adminhome");
        return model;
    }


}

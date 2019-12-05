package com.gaidau.cardGame.controller;

import com.gaidau.cardGame.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CardService cardService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Spring Boot + Thymeleaf rocks");
        model.addAttribute("cardList",cardService.findAll());
        return "home";
    }
}

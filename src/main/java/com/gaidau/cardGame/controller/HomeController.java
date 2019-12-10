package com.gaidau.cardGame.controller;

import com.gaidau.cardGame.service.CardService;
import com.gaidau.cardGame.service.ExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ExpressionService expressionService;
    private final CardService cardService;
    @GetMapping("/")
    public String home(Model model) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        expressionService.getMatches(list,24);

        model.addAttribute("message", "Spring Boot + Thymeleaf rocks");
        model.addAttribute("cardList",cardService.findAll());
        return "home";
    }
}

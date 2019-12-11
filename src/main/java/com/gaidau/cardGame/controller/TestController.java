package com.gaidau.cardGame.controller;

import com.gaidau.cardGame.bean.Foo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class TestController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Foo foo = new Foo();
        foo.setBar("bar");

        model.addAttribute("foo", foo);
        return "test";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute(value="foo") Foo foo) {
        log.info("loggg: "+foo.getBar());
        return "home";
    }


}

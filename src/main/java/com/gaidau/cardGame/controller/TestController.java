package com.gaidau.cardGame.controller;

import com.gaidau.cardGame.bean.Foo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
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

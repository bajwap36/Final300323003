package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal")
public class HomeController {
    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping()
    public String lowFive(MessageForm messageForm, Model model) {
//        messageListService.addMessage("Welcome, Grasshopper.");
        model.addAttribute("greetings", "Welcome, Grasshopper.");
        return "animal";
    }

    @PostMapping()
    public String highFive(MessageForm messageForm, Model model) {
//        messageListService.addMessage("We love " + messageForm.getAdjective() + " " + messageForm.getAnimalName() + "s.");
        model.addAttribute("greetings", "We love " + messageForm.getAdjective() + " " + messageForm.getAnimalName() + "s.");
        return "animal";
    }
}
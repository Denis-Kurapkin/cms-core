package ru.prostor.cms.core.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prostor.cms.core.backend.model.dto.response.AuthResponseDto;

@RestController
public class AuthPageController { //TODO добавить авторизацию

    @PostMapping("/auth")
    public String processAuth(@ModelAttribute("AuthDto") AuthResponseDto authDto) {
        return "redirect:/";
    }

    @GetMapping("/auth")
    public String getAuthPage() {
        return "auth";
    }
}

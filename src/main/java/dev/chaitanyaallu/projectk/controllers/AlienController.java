package dev.chaitanyaallu.projectk.controllers;

import dev.chaitanyaallu.projectk.dtos.AlienResponseDto;
import dev.chaitanyaallu.projectk.dtos.SignInRequestDto;
import dev.chaitanyaallu.projectk.dtos.SignUpRequestDto;
import dev.chaitanyaallu.projectk.services.AlienService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AlienController {
    private AlienService alienService;
    public AlienController(AlienService alienService){
        this.alienService = alienService;
    }
    @PostMapping("/login")
    public AlienResponseDto login(@Valid @RequestBody SignInRequestDto signInRequestDto){
        return alienService.login(signInRequestDto);
    }
    @PostMapping("/signup")
    public AlienResponseDto signup(@Valid @RequestBody SignUpRequestDto signUpRequestDto){
        return alienService.signup(signUpRequestDto);
    }
}

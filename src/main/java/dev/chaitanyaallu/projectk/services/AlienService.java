package dev.chaitanyaallu.projectk.services;

import dev.chaitanyaallu.projectk.dtos.AlienResponseDto;
import dev.chaitanyaallu.projectk.dtos.SignInRequestDto;
import dev.chaitanyaallu.projectk.dtos.SignUpRequestDto;

public interface AlienService {
    AlienResponseDto login(SignInRequestDto signInRequestDto);
    AlienResponseDto signup(SignUpRequestDto signUpRequestDto);
}

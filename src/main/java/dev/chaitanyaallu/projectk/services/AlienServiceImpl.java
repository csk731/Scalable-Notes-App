package dev.chaitanyaallu.projectk.services;

import dev.chaitanyaallu.projectk.dtos.AlienResponseDto;
import dev.chaitanyaallu.projectk.dtos.SignInRequestDto;
import dev.chaitanyaallu.projectk.dtos.SignUpRequestDto;
import dev.chaitanyaallu.projectk.models.Alien;
import dev.chaitanyaallu.projectk.repositories.AlienRepository;
import org.springframework.stereotype.Service;

@Service
public class AlienServiceImpl implements AlienService {

    private AlienRepository alienRepository;
    public AlienServiceImpl(AlienRepository alienRepository){
        this.alienRepository = alienRepository;
    }
    @Override
    public AlienResponseDto login(SignInRequestDto signInRequestDto) {
        return null;
    }

    @Override
    public AlienResponseDto signup(SignUpRequestDto signUpRequestDto) {
        Alien alien = new Alien();
        alien.setEmail(signUpRequestDto.getEmail());
        alien.setPassword(signUpRequestDto.getPassword());
        alien.setFirstName(signUpRequestDto.getFirstName());
        alien.setLastName(signUpRequestDto.getLastName());
        Alien savedAlien = alienRepository.save(alien);
        AlienResponseDto alienResponseDto = new AlienResponseDto();
        alienResponseDto.setAlienId(savedAlien.getId().toString());
        alienResponseDto.setEmail(savedAlien.getEmail());
        alienResponseDto.setName(savedAlien.getFirstName() + " " + savedAlien.getLastName());
        return alienResponseDto;
    }
}
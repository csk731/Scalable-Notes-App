package dev.chaitanyaallu.projectk.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlienResponseDto {
    String alienId;
    String name;
    String email;

}

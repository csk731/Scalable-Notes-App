package dev.chaitanyaallu.projectk.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShareNoteRequestDto {
    @NotEmpty(message = "Your-Alien-id cannot be empty")
    String alienId;
    @NotEmpty(message = "To-Alien-id cannot be empty")
    String toAlienId;
}

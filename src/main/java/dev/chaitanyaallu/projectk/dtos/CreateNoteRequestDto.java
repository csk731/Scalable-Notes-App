package dev.chaitanyaallu.projectk.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteRequestDto {
    @NotEmpty(message = "Alien id cannot be empty/null")
    String alienId;
    @NotBlank(message = "Title cannot be empty")
    @NotNull(message = "Title cannot be null")
    String title;
    @NotBlank(message = "Content cannot be empty")
    @NotNull(message = "Content cannot be null")
    String content;
}
package dev.chaitanyaallu.projectk.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteNoteRequestDto {
    @NotEmpty(message = "Title cannot be empty")
    @NotNull(message = "Title cannot be null")
    String title;
    @NotEmpty(message = "Content cannot be empty")
    @NotNull(message = "Content cannot be null")
    String content;
}

package dev.chaitanyaallu.projectk.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link dev.chaitanyaallu.projectk.models.Note}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteResponseDto{
    String id;
    String title;
    String content;
}
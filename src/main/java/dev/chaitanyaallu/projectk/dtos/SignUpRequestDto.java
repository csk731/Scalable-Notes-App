package dev.chaitanyaallu.projectk.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    @Email(message = "Not a valid email")
    @NotBlank(message = "Email cannot be empty")
    @NotNull(message = "Email cannot be null")
    String email;
    @NotBlank(message = "Password cannot be empty")
    @NotNull(message = "Password cannot be null")
//    @Min(value = 8, message = "Password must be at least 8 characters long")
//    @Max(value = 32, message = "Password must be at most 32 characters long")
    String password;
    @NotEmpty(message = "First name cannot be empty/null")
    String firstName;
    @NotBlank(message = "Last name cannot be empty")
    @NotNull(message = "Last name cannot be null")
    String lastName;
}

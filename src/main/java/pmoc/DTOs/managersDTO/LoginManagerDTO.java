package pmoc.DTOs.managersDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginManagerDTO(
        @Email
        String email,
        @NotBlank
        //@Size(max = 20, min = 6)
        String password
) {
}

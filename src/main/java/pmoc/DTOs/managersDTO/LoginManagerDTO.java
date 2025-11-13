package pmoc.DTOs.managersDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginManagerDTO(
        @NotBlank
        String username,
        @NotBlank
        @Size(max = 20, min = 6)
        String password
) {
}

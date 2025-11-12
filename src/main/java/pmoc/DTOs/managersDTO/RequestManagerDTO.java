package pmoc.DTOs.managersDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

public record RequestManagerDTO(
        @NotBlank
        @Size(max = 20, min = 5)
        String username,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(max = 20, min = 6)
        String password
) {
}

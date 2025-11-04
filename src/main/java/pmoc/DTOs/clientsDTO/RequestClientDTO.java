package pmoc.DTOs.clientsDTO;

import jakarta.validation.constraints.NotBlank;

public record RequestClientDTO(
    @NotBlank
    String name,
    @NotBlank
    String phone,

    @NotBlank
    String address,
    String room,
    String department
) {
}

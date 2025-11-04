package pmoc.DTOs.clientsDTO;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record RequestClientDTO(
    @NotBlank
    String name,
    @NotBlank
    String phone,

    @NotBlank
    String address,
    String room,
    String department,

    boolean filter,
    boolean diffusers,
    boolean equipments,

    LocalDateTime date,
    String observations
) {
}

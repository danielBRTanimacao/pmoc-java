package pmoc.DTOs.mechaniciansDTO;

import jakarta.validation.constraints.NotBlank;

public record RequestMechanicianDTO(
    @NotBlank
    String name,
    @NotBlank
    String phone) {}

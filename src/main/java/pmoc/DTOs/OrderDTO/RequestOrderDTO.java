package pmoc.DTOs.OrderDTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestOrderDTO(
    @NotNull
    Long clientId,
    @NotNull
    Long mecId,

    @NotBlank
    String problem,

    @DecimalMin(value = "5.0")
    @Digits(integer=3, fraction=2)
    BigDecimal price,
    String observations
) {}

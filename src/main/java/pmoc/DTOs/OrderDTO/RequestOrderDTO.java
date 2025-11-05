package pmoc.DTOs.OrderDTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import pmoc.entities.ClientsEntity;
import pmoc.entities.MechanicsEntity;
import pmoc.entities.enums.ordered.OrderStatusEnum;

public record RequestOrderDTO(
    @NotBlank
    ClientsEntity clientId,
    @NotBlank
    MechanicsEntity mecId,

    OrderStatusEnum status,
    @NotBlank
    String problem,

    @NotBlank
    BigDecimal value,
    String observations
) {}

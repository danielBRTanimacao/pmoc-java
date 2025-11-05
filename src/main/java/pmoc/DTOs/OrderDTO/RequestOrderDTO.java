package pmoc.DTOs.OrderDTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import pmoc.entities.ClientsEntity;
import pmoc.entities.MechaniciansEntity;
import pmoc.entities.enums.ordered.OrderStatusEnum;

public record RequestOrderDTO(
    @NotBlank
    ClientsEntity clientId,
    @NotBlank
    MechaniciansEntity mecId,

    OrderStatusEnum status,
    @NotBlank
    String problem,

    @NotBlank
    BigDecimal value,
    String observations
) {}

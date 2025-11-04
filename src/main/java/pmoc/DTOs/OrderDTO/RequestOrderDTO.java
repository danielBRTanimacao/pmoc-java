package pmoc.DTOs.OrderDTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import pmoc.entities.ClientsEntity;
import pmoc.entities.MechaniciansEntity;
import pmoc.entities.enums.ordered.OrderStatusEnum;
import pmoc.entities.extension.EquipamentsEntity;

public record RequestOrderDTO(
    @NotBlank
    ClientsEntity clientId,
    @NotBlank
    MechaniciansEntity mecId,

    OrderStatusEnum status,
    @NotBlank
    String problem,

    @NotBlank
    EquipamentsEntity equipaments_id,
    @NotBlank
    BigDecimal value,
    String observations
) {}

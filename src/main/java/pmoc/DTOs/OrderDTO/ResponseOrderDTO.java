package pmoc.DTOs.OrderDTO;

import java.math.BigDecimal;

public record ResponseOrderDTO (
        String nameClient,
        String nameMechanic,
        Long orderPosition,
        BigDecimal price
) {}

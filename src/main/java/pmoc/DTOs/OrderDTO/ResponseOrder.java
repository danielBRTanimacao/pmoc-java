package pmoc.DTOs.OrderDTO;

import java.math.BigDecimal;

public record ResponseOrder(
        String nameClient,
        String nameMechanic,
        Long orderPosition,
        BigDecimal price
) {
}

package pmoc.DTOs.managersDTO;

import java.util.UUID;

public record ResponseTokenDTO(
        UUID id,
        String token
) {
}

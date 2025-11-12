package pmoc.DTOs.clientsDTO;

import java.util.List;

public record PaginateClients(
        Long id,
        String name,
        List<String> orders
) {
}

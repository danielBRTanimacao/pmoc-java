package pmoc.DTOs.clientsDTO;

import java.time.LocalDateTime;

public record RequestClientDTO(
    String name,
    String phone,

    String adress,
    String building,
    String room,
    String to_walk,
    String department,
    
    String equipment_name,
    String voltage,
    String temperature,
    String gas_preassure,

    boolean filter,
    boolean cabinet,
    boolean evaporator,
    boolean grukks,
    boolean diffusers,
    boolean bactericidal,
    boolean paletts,
    boolean remote_control,
    boolean equipments,
    boolean cracks,

    LocalDateTime date,
    String observations
) {
}

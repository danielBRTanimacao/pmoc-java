package pmoc.mapper;

import pmoc.DTOs.mechaniciansDTO.RequestMechanicianDTO;
import pmoc.entities.MechanicsEntity;

public interface MechanicMapper {
    MechanicsEntity toEntity(RequestMechanicianDTO data);
}

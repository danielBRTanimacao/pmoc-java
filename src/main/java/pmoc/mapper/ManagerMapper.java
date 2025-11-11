package pmoc.mapper;

import pmoc.DTOs.managersDTO.RequestManagerDTO;
import pmoc.entities.ManagersEntity;

public interface ManagerMapper {
    ManagersEntity toEntity(RequestManagerDTO data);
    ManagersEntity partialUpdate(ManagersEntity updtEntity, ManagersEntity data);
}

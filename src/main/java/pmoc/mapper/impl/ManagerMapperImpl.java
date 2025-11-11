package pmoc.mapper.impl;

import org.springframework.stereotype.Component;
import pmoc.DTOs.managersDTO.RequestManagerDTO;
import pmoc.entities.ManagersEntity;
import pmoc.entities.enums.manager.SignaturesEnum;
import pmoc.entities.enums.manager.StatusEnum;
import pmoc.mapper.ManagerMapper;

@Component
public class ManagerMapperImpl implements ManagerMapper {
    @Override
    public ManagersEntity toEntity(RequestManagerDTO data) {
        if (data == null) {
            return null;
        }
        ManagersEntity entity = new ManagersEntity();
        entity.setUsername(data.username());
        entity.setEmail(data.email());
        entity.setPassword(data.password());
        entity.setStatus(StatusEnum.PENDING);
        entity.setSignature(SignaturesEnum.FREE);

        return entity;
    }

    @Override
    public ManagersEntity partialUpdate(ManagersEntity updtEntity, ManagersEntity data) {
        return null;
    }
}

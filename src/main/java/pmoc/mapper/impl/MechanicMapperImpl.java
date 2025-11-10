package pmoc.mapper.impl;

import org.springframework.stereotype.Component;
import pmoc.DTOs.mechaniciansDTO.RequestMechanicianDTO;
import pmoc.entities.MechanicsEntity;
import pmoc.mapper.MechanicMapper;

@Component
public class MechanicMapperImpl implements MechanicMapper {

    @Override
    public MechanicsEntity toEntity(RequestMechanicianDTO data) {
        if (data == null) {
            return null;
        }
        MechanicsEntity entity = new MechanicsEntity();
        entity.setName(data.name());
        entity.setPhone(data.phone());

        return entity;
    }

    @Override
    public MechanicsEntity partialUpdate(MechanicsEntity updtEntity, MechanicsEntity data) {
        if (data == null) {
            return null;
        }

        if (data.getName() != null) {
            updtEntity.setName(data.getName());
        }
        if (data.getPhone() != null) {
            updtEntity.setPhone(data.getPhone());
        }
        return updtEntity;
    }
}

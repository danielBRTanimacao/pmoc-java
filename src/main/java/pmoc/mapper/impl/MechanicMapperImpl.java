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
        entity.setName(data.phone());
        entity.setPhone(data.phone());

        return entity;
    }
}

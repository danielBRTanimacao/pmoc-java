package pmoc.mapper.impl;

import org.springframework.stereotype.Component;
import pmoc.DTOs.clientsDTO.RequestClientDTO;
import pmoc.entities.ClientsEntity;
import pmoc.mapper.ClientMapper;

@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientsEntity toEntity(RequestClientDTO data) {
        if (data == null) {
            return null;
        }
        ClientsEntity entity = new ClientsEntity();
        entity.setName(data.name());
        entity.setPhone(data.phone());
        entity.setAddress(data.address());
        entity.setRoom(data.room());
        entity.setDepartment(data.department());

        return entity;
    }
}

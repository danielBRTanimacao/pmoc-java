package pmoc.mapper;

import pmoc.DTOs.clientsDTO.RequestClientDTO;
import pmoc.entities.ClientsEntity;

public interface ClientMapper {
    ClientsEntity toEntity(RequestClientDTO data);
}

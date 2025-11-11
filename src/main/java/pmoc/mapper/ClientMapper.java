package pmoc.mapper;

import pmoc.DTOs.clientsDTO.RequestClientDTO;
import pmoc.DTOs.clientsDTO.ResponseClientDTO;
import pmoc.entities.ClientsEntity;

public interface ClientMapper {
    ClientsEntity toEntity(RequestClientDTO data);
    ClientsEntity partialUpdate(ClientsEntity updtEntity, ClientsEntity data);
    ResponseClientDTO toDTO(ClientsEntity data);
}

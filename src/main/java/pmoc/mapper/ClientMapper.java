package pmoc.mapper;

import pmoc.DTOs.clientsDTO.PaginateClients;
import pmoc.DTOs.clientsDTO.RequestClientDTO;
import pmoc.DTOs.clientsDTO.ResponseClientDTO;
import pmoc.entities.ClientsEntity;

public interface ClientMapper {
    PaginateClients toPaginateDTO(ClientsEntity data);
    ClientsEntity toEntity(RequestClientDTO data);
    ClientsEntity partialUpdate(ClientsEntity updtEntity, ClientsEntity data);
    ResponseClientDTO toDTO(ClientsEntity data);
}

package pmoc.services;

import org.springframework.data.domain.Page;

import pmoc.DTOs.clientsDTO.ResponseClientDTO;
import pmoc.entities.ClientsEntity;

public interface ClientService {
    Page<ClientsEntity> getAllClients(int pageNum, int pageSize);
    ResponseClientDTO createClient(ClientsEntity data);
    void delClient(Long id);
}

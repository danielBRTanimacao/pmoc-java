package pmoc.services;

import org.springframework.data.domain.Page;

import pmoc.DTOs.clientsDTO.ResponseClientDTO;
import pmoc.entities.ClientsEntity;

public interface ClientService {
    ClientsEntity getClient(Long id);
    Page<ClientsEntity> getAllClients(int pageNum, int pageSize);
    ResponseClientDTO createClient(ClientsEntity data);
    ResponseClientDTO updtClient(ClientsEntity data, Long id);
    void delClient(Long id);
}

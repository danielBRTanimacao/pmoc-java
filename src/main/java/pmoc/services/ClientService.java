package pmoc.services;

import org.springframework.data.domain.Page;

import pmoc.entities.ClientEntity;

public interface ClientService {
    Page<ClientEntity> getAllClients(int pageNum, int pageSize);
}

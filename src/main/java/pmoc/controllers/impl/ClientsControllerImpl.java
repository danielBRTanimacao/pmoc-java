package pmoc.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pmoc.controllers.ClientsController;
import pmoc.entities.ClientEntity;
import pmoc.services.ClientService;

@RestController
@RequiredArgsConstructor
public class ClientsControllerImpl implements ClientsController {

    private final ClientService clientService;

    @Override
    public Page<ClientEntity> paginateAllClients(int pageNum, int pageSize) {
        return clientService.getAllClients(pageNum, pageSize);
    }
    
}

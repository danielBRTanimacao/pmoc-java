package pmoc.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Page<ClientEntity>> paginateAllClients(int pageNum, int pageSize) {
        return ResponseEntity.ok().body(clientService.getAllClients(pageNum, pageSize));
    }

   
    
}

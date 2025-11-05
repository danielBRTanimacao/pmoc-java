package pmoc.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pmoc.DTOs.clientsDTO.RequestClientDTO;
import pmoc.DTOs.clientsDTO.ResponseClientDTO;
import pmoc.controllers.ClientsController;
import pmoc.entities.ClientsEntity;
import pmoc.services.ClientService;

@RestController
@RequiredArgsConstructor
public class ClientsControllerImpl implements ClientsController {

    private final ClientService clientService;

    @Override
    public ResponseEntity<Page<ClientsEntity>> paginateAllClients(int pageNum, int pageSize) {
        return ResponseEntity.ok().body(clientService.getAllClients(pageNum, pageSize));
    }

    @Override
    public ResponseEntity<ResponseClientDTO> addNewClient(@Valid RequestClientDTO data) {
        ClientsEntity preClient = new ClientsEntity();

        preClient.setName(data.name());
        preClient.setPhone(data.phone());
        preClient.setAddress(data.address());

        return ResponseEntity.ok().body(clientService.createClient(preClient));
    }

    @Override
    public ResponseEntity<?> deleteClient(@Valid Long id) {
        clientService.delClient(id);
        return ResponseEntity.noContent().build();
    }
    
}

package pmoc.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pmoc.DTOs.clientsDTO.PaginateClients;
import pmoc.DTOs.clientsDTO.RequestClientDTO;
import pmoc.DTOs.clientsDTO.ResponseClientDTO;
import pmoc.controllers.ClientsController;
import pmoc.entities.ClientsEntity;
import pmoc.mapper.ClientMapper;
import pmoc.services.ClientService;

@RestController
@RequiredArgsConstructor
public class ClientsControllerImpl implements ClientsController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Override
    public ResponseEntity<ClientsEntity> getInfoClient(Long id) {
        return ResponseEntity.ok().body(clientService.getClient(id));
    }

    @Override
    public ResponseEntity<Page<PaginateClients>> paginateAllClients(int pageNum, int pageSize) {
        return ResponseEntity.ok().body(clientService.getAllClients(pageNum, pageSize));
    }

    @Override
    public ResponseEntity<ResponseClientDTO> addNewClient(@Valid RequestClientDTO data) {
        ClientsEntity preClient = clientMapper.toEntity(data);
        return new ResponseEntity<>(clientService.createClient(preClient), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseClientDTO> updateClient(RequestClientDTO data, Long id) {
        ClientsEntity preClient = clientMapper.toEntity(data);
        return ResponseEntity.ok().body(clientService.updtClient(preClient, id));
    }

    @Override
    public ResponseEntity<?> deleteClient(@Valid Long id) {
        clientService.delClient(id);
        return ResponseEntity.noContent().build();
    }
    
}

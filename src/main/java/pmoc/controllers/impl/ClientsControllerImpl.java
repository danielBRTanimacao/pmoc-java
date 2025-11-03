package pmoc.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pmoc.DTOs.clientsDTO.RequestClientDTO;
import pmoc.DTOs.clientsDTO.ResponseClientDTO;
import pmoc.controllers.ClientsController;
import pmoc.entities.ClientsEntity;
import pmoc.entities.extension.AddressesEntity;
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
        AddressesEntity preAddress = new AddressesEntity();

        preAddress.setAdress(data.adress());

        preClient.setName(data.name());
        preClient.setPhone(data.phone());
        preClient.setAddress(preAddress);

        return ResponseEntity.ok().body(clientService.createClient(preClient));
    }
    
}

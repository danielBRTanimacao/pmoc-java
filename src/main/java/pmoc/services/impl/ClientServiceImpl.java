package pmoc.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pmoc.DTOs.clientsDTO.ResponseClientDTO;
import pmoc.entities.ClientsEntity;
import pmoc.exceptions.customs.NotFoundException;
import pmoc.repositories.ClientsRepository;
import pmoc.services.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientsRepository clientRepository;

    @Override
    public Page<ClientsEntity> getAllClients(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("id").descending());
        return clientRepository.findAll(pageable);
    }

    @Override
    public ResponseClientDTO createClient(ClientsEntity data) {
        clientRepository.save(data);
        return new ResponseClientDTO(data.getName(), data.getAddress());
    }

    @Override
    public ResponseClientDTO updtClient(ClientsEntity data, Long id) {
        ClientsEntity preSave = clientRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Client with id=" + id + " not found")
        );

        preSave.setName(data.getName());
        preSave.setAddress(data.getAddress());
        preSave.setPhone(data.getPhone());
        clientRepository.save(preSave);
        return new ResponseClientDTO(preSave.getName(), preSave.getAddress());
    }

    @Override
    public void delClient(Long id) {
        clientRepository.deleteById(id);
    }
    
}
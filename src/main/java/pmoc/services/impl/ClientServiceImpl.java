package pmoc.services.impl;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pmoc.entities.ClientEntity;
import pmoc.repositories.ClientRepository;
import pmoc.services.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Override
    public Page<ClientEntity> getAllClients(int pageNum, int pageSize) {
        // Corrigir aqui
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return clientRepository.findAll(pageable);
    }
    
}
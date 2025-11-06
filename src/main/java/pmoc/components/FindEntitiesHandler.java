package pmoc.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pmoc.entities.ClientsEntity;
import pmoc.entities.MechanicsEntity;
import pmoc.exceptions.customs.NotFoundException;
import pmoc.repositories.ClientsRepository;
import pmoc.repositories.MechanicsRepository;
import pmoc.repositories.OrdersRepository;

@Component
@RequiredArgsConstructor
public class FindEntitiesHandler {
    private final ClientsRepository clientsRepository;
    private final MechanicsRepository mechanicsRepository;

    public ClientsEntity findClientById(Long id) {
        return clientsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Client with id " + id + " Not found")
        );
    }

    public MechanicsEntity findMechanicById(Long id) {
        return mechanicsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Client with id " + id + " Not found")
        );
    }

}

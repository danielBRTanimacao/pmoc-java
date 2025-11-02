package pmoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pmoc.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    
}

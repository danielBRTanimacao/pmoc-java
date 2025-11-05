package pmoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pmoc.entities.ClientsEntity;

public interface ClientsRepository extends JpaRepository<ClientsEntity, Long> {
    
}

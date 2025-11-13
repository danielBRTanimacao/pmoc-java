package pmoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pmoc.entities.ManagersEntity;

import java.util.Optional;
import java.util.UUID;

public interface ManagersRepository extends JpaRepository<ManagersEntity, UUID> {
    Optional<ManagersEntity> findByUsername(String login);
}

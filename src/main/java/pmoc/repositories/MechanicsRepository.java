package pmoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pmoc.entities.MechanicsEntity;

public interface MechanicsRepository extends JpaRepository<MechanicsEntity, Long>{
    
}

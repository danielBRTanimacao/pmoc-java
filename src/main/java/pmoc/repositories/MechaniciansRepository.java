package pmoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pmoc.entities.MechaniciansEntity;

public interface MechaniciansRepository extends JpaRepository<MechaniciansEntity, Long>{
    
}

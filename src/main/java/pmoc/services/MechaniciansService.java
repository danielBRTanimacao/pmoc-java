package pmoc.services;

import org.springframework.data.domain.Page;

import pmoc.entities.MechanicsEntity;

public interface MechaniciansService {
    Page<MechanicsEntity> getAllMechanicias(int pageNum, int pageSize);
    MechanicsEntity createNewMecanic(MechanicsEntity data);
}

package pmoc.services;

import org.springframework.data.domain.Page;

import pmoc.DTOs.mechaniciansDTO.ResponseMechanicDTO;
import pmoc.entities.MechanicsEntity;

public interface MechanicsService {
    Page<MechanicsEntity> getAllMechanics(int pageNum, int pageSize);
    ResponseMechanicDTO createNewMechanic(MechanicsEntity data);
    ResponseMechanicDTO updtMechanic(MechanicsEntity data, Long id);
    void delMechanic(Long id);
}

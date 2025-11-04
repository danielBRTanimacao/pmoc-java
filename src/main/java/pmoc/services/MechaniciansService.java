package pmoc.services;

import org.springframework.data.domain.Page;

import pmoc.DTOs.mechaniciansDTO.RequestMechanicianDTO;
import pmoc.entities.MechaniciansEntity;

public interface MechaniciansService {
    Page<MechaniciansEntity> getAllMechanicias(int pageNum, int pageSize);
    MechaniciansEntity createNewMecanic(RequestMechanicianDTO data);
}

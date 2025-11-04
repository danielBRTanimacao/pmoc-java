package pmoc.services.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pmoc.DTOs.mechaniciansDTO.RequestMechanicianDTO;
import pmoc.entities.MechaniciansEntity;
import pmoc.repositories.MechaniciansRepository;
import pmoc.services.MechaniciansService;

@Service
@RequiredArgsConstructor
public class MechaniciansServiceImpl implements MechaniciansService {

    private final MechaniciansRepository mechaniciansRepository;

    @Override
    public Page<MechaniciansEntity> getAllMechanicias(int pageNum, int pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize);
        return mechaniciansRepository.findAll(page);
    }

    @Override
    public MechaniciansEntity createNewMecanic(MechaniciansEntity data) {
        return mechaniciansRepository.save(data);
    }
    
}

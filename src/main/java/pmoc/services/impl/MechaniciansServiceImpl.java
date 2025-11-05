package pmoc.services.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pmoc.entities.MechanicsEntity;
import pmoc.repositories.MechanicsRepository;
import pmoc.services.MechaniciansService;

@Service
@RequiredArgsConstructor
public class MechaniciansServiceImpl implements MechaniciansService {

    private final MechanicsRepository mechaniciansRepository;

    @Override
    public Page<MechanicsEntity> getAllMechanicias(int pageNum, int pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize);
        return mechaniciansRepository.findAll(page);
    }

    @Override
    public MechanicsEntity createNewMecanic(MechanicsEntity data) {
        return mechaniciansRepository.save(data);
    }
    
}

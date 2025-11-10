package pmoc.services.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pmoc.DTOs.mechaniciansDTO.ResponseMechanicDTO;
import pmoc.entities.MechanicsEntity;
import pmoc.exceptions.customs.NotFoundException;
import pmoc.mapper.MechanicMapper;
import pmoc.repositories.MechanicsRepository;
import pmoc.services.MechanicsService;

@Service
@RequiredArgsConstructor
public class MechanicsServiceImpl implements MechanicsService {

    private final MechanicsRepository mechanicsRepository;
    private final MechanicMapper mechanicMapper;

    @Override
    public Page<MechanicsEntity> getAllMechanics(int pageNum, int pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize);
        return mechanicsRepository.findAll(page);
    }

    @Override
    public MechanicsEntity createNewMechanic(MechanicsEntity data) {
        return mechanicsRepository.save(data);
    }

    @Override
    public ResponseMechanicDTO updtMechanic(MechanicsEntity data, Long id) {
        MechanicsEntity mech = mechanicsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Mechanic with id " + id + " Not found")
        );
        mech = mechanicMapper.partialUpdate(mech, data);
        mechanicsRepository.save(mech);
        return new ResponseMechanicDTO(mech.getName(), mech.getPhone());
    }

    @Override
    public void delMechanic(Long id) {
        MechanicsEntity mech = mechanicsRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Mechanic with id " + id + " Not found")
        );
        mechanicsRepository.delete(mech);
    }

}

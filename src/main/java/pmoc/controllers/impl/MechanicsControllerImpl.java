package pmoc.controllers.impl;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pmoc.DTOs.mechaniciansDTO.RequestMechanicianDTO;
import pmoc.DTOs.mechaniciansDTO.ResponseMechanicDTO;
import pmoc.controllers.MechanicsController;
import pmoc.entities.MechanicsEntity;
import pmoc.services.MechanicsService;

@RestController
@RequiredArgsConstructor
public class MechanicsControllerImpl implements MechanicsController {
    
    private final MechanicsService mechanicsService;
    
    @Override
    public ResponseEntity<Page<MechanicsEntity>> paginateAllMechanics(int pageNum, int pageSize) {
        return ResponseEntity.ok().body(mechanicsService.getAllMechanics(pageNum, pageSize));
    }

    @Override
    public ResponseEntity<MechanicsEntity> addNewMechanic(RequestMechanicianDTO data) {
        MechanicsEntity preMechanic = new MechanicsEntity();

        preMechanic.setName(data.name());
        preMechanic.setPhone(data.phone());
        return new ResponseEntity<>(mechanicsService.createNewMechanic(preMechanic), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseMechanicDTO> updateMechanic(RequestMechanicianDTO data, Long id) {
        MechanicsEntity preMechanic = new MechanicsEntity();

        preMechanic.setName(data.name());
        preMechanic.setPhone(data.phone());
        return ResponseEntity.ok().body(mechanicsService.updtMechanic(preMechanic, id));
    }

    @Override
    public ResponseEntity<?> deleteMechanic(Long id) {
        mechanicsService.delMechanic(id);
        return ResponseEntity.noContent().build();
    }

}

package pmoc.controllers.impl;

import java.net.http.HttpRequest;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pmoc.DTOs.mechaniciansDTO.RequestMechanicianDTO;
import pmoc.controllers.MechaniciansController;
import pmoc.entities.MechaniciansEntity;
import pmoc.services.MechaniciansService;

@RestController
@RequiredArgsConstructor
public class MechaniciansControllerImpl implements MechaniciansController{
    
    private final MechaniciansService mechaniciansService;
    
    @Override
    public ResponseEntity<Page<MechaniciansEntity>> paginateAllMecanics(int pageNum, int pageSize) {
        return ResponseEntity.ok().body(mechaniciansService.getAllMechanicias(pageNum, pageSize));
    }

    @Override
    public ResponseEntity<MechaniciansEntity> addNewMecanic(RequestMechanicianDTO data) {
        MechaniciansEntity preMecanic = new MechaniciansEntity();

        preMecanic.setName(data.name());
        preMecanic.setPhone(data.phone());
        return ResponseEntity.ok().body(mechaniciansService.createNewMecanic(preMecanic));
    }
    
}

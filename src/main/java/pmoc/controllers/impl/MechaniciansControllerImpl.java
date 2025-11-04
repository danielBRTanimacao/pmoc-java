package pmoc.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
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
    
}

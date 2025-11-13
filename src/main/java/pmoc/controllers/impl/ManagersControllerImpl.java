package pmoc.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;
import pmoc.DTOs.managersDTO.LoginManagerDTO;
import pmoc.DTOs.managersDTO.RequestManagerDTO;
import pmoc.DTOs.managersDTO.RequestTokenDTO;
import pmoc.DTOs.managersDTO.ResponseTokenDTO;
import pmoc.controllers.ManagersController;
import pmoc.mapper.ManagerMapper;
import pmoc.services.ManagersService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ManagersControllerImpl implements ManagersController {
    private final ManagersService managersService;
    private final ManagerMapper managerMapper;

    @Override
    public ResponseEntity<?> validateToken(RequestTokenDTO data, Authentication auth, UUID id) {
        managersService.validToken(data.token(), auth, id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ResponseTokenDTO> loginManager(LoginManagerDTO data) {
        return ResponseEntity.ok().body(managersService.login(data));
    }

    @Override
    public ResponseEntity<?> createNewManager(RequestManagerDTO data) {
        managersService.createManager(managerMapper.toEntity(data));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateManager(RequestManagerDTO data, Authentication auth, UUID id) {
        managersService.updtManager(managerMapper.toEntity(data), auth, id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> deleteManager(Authentication auth, UUID id) {
        managersService.delManager(auth, id);
        return ResponseEntity.noContent().build();
    }
}

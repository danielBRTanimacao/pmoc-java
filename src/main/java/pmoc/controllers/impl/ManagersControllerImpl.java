package pmoc.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pmoc.DTOs.managersDTO.RequestManagerDTO;
import pmoc.controllers.ManagersController;

@RestController
@RequiredArgsConstructor
public class ManagersControllerImpl implements ManagersController {
    @Override
    public ResponseEntity<?> createNewManager(RequestManagerDTO data) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateManager(RequestManagerDTO data) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteManager() {
        return null;
    }
}

package pmoc.services;

import org.springframework.security.core.Authentication;
import pmoc.DTOs.managersDTO.LoginManagerDTO;
import pmoc.DTOs.managersDTO.ResponseTokenDTO;
import pmoc.entities.ManagersEntity;

import java.util.UUID;

public interface ManagersService {
    void createManager(ManagersEntity data);
    void updtManager(ManagersEntity data, Authentication auth, UUID id);
    void delManager(Authentication auth, UUID id);
    ResponseTokenDTO login(LoginManagerDTO data);
    void validToken(String token, Authentication auth);
}

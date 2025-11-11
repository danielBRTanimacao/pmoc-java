package pmoc.services;

import org.springframework.security.core.Authentication;
import pmoc.DTOs.managersDTO.LoginManagerDTO;
import pmoc.DTOs.managersDTO.ResponseTokenDTO;
import pmoc.entities.ManagersEntity;

public interface ManagersService {
    void createManager(ManagersEntity data);
    void updtManager(ManagersEntity data, Authentication auth);
    void delManager(Authentication auth);
    ResponseTokenDTO login(LoginManagerDTO data);
    void validToken(String token, Authentication auth);
}

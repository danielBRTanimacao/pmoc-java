package pmoc.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pmoc.DTOs.managersDTO.LoginManagerDTO;
import pmoc.DTOs.managersDTO.ResponseTokenDTO;
import pmoc.entities.ManagersEntity;
import pmoc.exceptions.customs.JWTAuthException;
import pmoc.exceptions.customs.NotFoundException;
import pmoc.mapper.ManagerMapper;
import pmoc.repositories.ManagersRepository;
import pmoc.services.ManagersService;
import pmoc.services.TokenService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManagersServiceImpl implements ManagersService {

    private final ManagersRepository managersRepository;
    private final ManagerMapper managerMapper;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createManager(ManagersEntity data) {
        data.setPassword(
                passwordEncoder.encode(
                        data.getPassword()
                )
        );
        managersRepository.save(data);
    }

    @Override
    public ResponseTokenDTO login(LoginManagerDTO data) {
        ManagersEntity manager = managersRepository.findByEmail(data.email()).orElseThrow(
                () -> new NotFoundException("Manager not found!")
        );

        if (!passwordEncoder.matches(data.password(), manager.getPassword())) {
            throw new JWTAuthException("Wrong password!");
        }

        String token = tokenService.generateToken(manager);

        return new ResponseTokenDTO(manager.getId(), token);
    }

    @Override
    public void validToken(String token, Authentication auth) {

    }

    @Override
    public void updtManager(ManagersEntity data, Authentication auth, UUID id) {
        ManagersEntity authenticatedManager = (ManagersEntity) auth.getPrincipal();

        if (!authenticatedManager.getId().equals(id)) {
            throw new AccessDeniedException("Access denied!");
        }

        ManagersEntity managerToUpdt = managersRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Manager not found!")
        );

        ManagersEntity updatedManager = managerMapper.partialUpdate(managerToUpdt, data);
        managersRepository.save(updatedManager);
    }

    @Override
    public void delManager(Authentication auth, UUID id) {
        ManagersEntity authenticatedManager = (ManagersEntity) auth.getPrincipal();

        if (!authenticatedManager.getId().equals(id)) {
            throw new AccessDeniedException("Access denied!");
        }

        managersRepository.deleteById(id);
    }
}

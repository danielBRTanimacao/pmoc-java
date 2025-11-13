package pmoc.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pmoc.DTOs.managersDTO.RequestManagerDTO;
import pmoc.components.TokenGenerator;
import pmoc.entities.ManagersEntity;
import pmoc.entities.enums.manager.SignaturesEnum;
import pmoc.entities.enums.manager.StatusEnum;
import pmoc.mapper.ManagerMapper;

@Component
@RequiredArgsConstructor
public class ManagerMapperImpl implements ManagerMapper {
    private final PasswordEncoder passwordEncoder;

    @Override
    public ManagersEntity toEntity(RequestManagerDTO data) {
        if (data == null) {
            return null;
        }
        ManagersEntity entity = new ManagersEntity();
        entity.setUsername(data.username());
        entity.setEmail(data.email());
        entity.setPassword(data.password());
        entity.setToken(TokenGenerator.sixCharToken());
        entity.setStatus(StatusEnum.PENDING);
        entity.setSignature(SignaturesEnum.FREE);

        return entity;
    }

    @Override
    public ManagersEntity partialUpdate(ManagersEntity updtEntity, ManagersEntity data) {
        if (data == null) {
            return null;
        }

        if (data.getUsername() != null) {
            updtEntity.setUsername(data.getUsername());
        }
        if (data.getPassword() != null) {
            updtEntity.setPassword(passwordEncoder.encode(data.getPassword()));
        }
        return updtEntity;
    }
}

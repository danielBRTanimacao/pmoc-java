package pmoc.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pmoc.DTOs.managersDTO.LoginManagerDTO;
import pmoc.DTOs.managersDTO.RequestManagerDTO;
import pmoc.DTOs.managersDTO.RequestTokenDTO;
import pmoc.DTOs.managersDTO.ResponseTokenDTO;

import java.util.UUID;

@RequestMapping("/api/auth")
public interface ManagersController {
    @PostMapping("/token")
    ResponseEntity<?> validateToken(@Valid @RequestBody RequestTokenDTO data, Authentication auth);
    @PostMapping("/login")
    ResponseEntity<ResponseTokenDTO> loginManager(@Valid @RequestBody LoginManagerDTO data);
    @PostMapping
    ResponseEntity<?> createNewManager(@Valid @RequestBody RequestManagerDTO data);
    @PutMapping("/{id}")
    ResponseEntity<?> updateManager(
            @Valid @RequestBody RequestManagerDTO data,
            Authentication auth,
            @PathVariable UUID id
    );
    @DeleteMapping
    ResponseEntity<?> deleteManager(Authentication auth);
}

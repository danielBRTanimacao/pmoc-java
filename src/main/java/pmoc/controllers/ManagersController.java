package pmoc.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pmoc.DTOs.managersDTO.RequestManagerDTO;

@RequestMapping("/api/auth")
public interface ManagersController {
    // post 'login' manager
    @PostMapping
    ResponseEntity<?> createNewManager(@Valid @RequestBody RequestManagerDTO data);
    @PutMapping
    ResponseEntity<?> updateManager(@Valid @RequestBody RequestManagerDTO data);
    @DeleteMapping
    ResponseEntity<?> deleteManager(@Valid @RequestBody RequestManagerDTO data);
}

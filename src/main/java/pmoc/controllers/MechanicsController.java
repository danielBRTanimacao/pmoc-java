package pmoc.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pmoc.DTOs.mechaniciansDTO.RequestMechanicianDTO;
import pmoc.DTOs.mechaniciansDTO.ResponseMechanicDTO;
import pmoc.entities.MechanicsEntity;

@RequestMapping("/api/mechanics")
public interface MechanicsController {
    @GetMapping
    ResponseEntity<Page<MechanicsEntity>> paginateAllMechanics(
        @RequestParam(defaultValue = "0") int pageNum,
        @RequestParam(defaultValue = "25") int pageSize
    );

    @PostMapping
    ResponseEntity<ResponseMechanicDTO> addNewMechanic(@Valid @RequestBody RequestMechanicianDTO data);

    @PutMapping("/{id}")
    ResponseEntity<ResponseMechanicDTO> updateMechanic(
            @Valid @RequestBody RequestMechanicianDTO data,
            @PathVariable Long id
    );

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteMechanic(@PathVariable Long id);
}

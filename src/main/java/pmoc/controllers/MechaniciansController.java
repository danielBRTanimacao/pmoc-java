package pmoc.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import pmoc.DTOs.mechaniciansDTO.RequestMechanicianDTO;
import pmoc.entities.MechaniciansEntity;

@RequestMapping("/api/mecanics")
public interface MechaniciansController {
    @GetMapping
    ResponseEntity<Page<MechaniciansEntity>> paginateAllMecanics(
        @RequestParam(defaultValue = "0") int pageNum,
        @RequestParam(defaultValue = "25") int pageSize
    );

    @PostMapping
    ResponseEntity<MechaniciansEntity> addNewMecanic(@Valid @RequestBody RequestMechanicianDTO data);
}

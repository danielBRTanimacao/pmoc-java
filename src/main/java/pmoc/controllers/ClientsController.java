package pmoc.controllers;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pmoc.DTOs.clientsDTO.PaginateClients;
import pmoc.DTOs.clientsDTO.RequestClientDTO;
import pmoc.DTOs.clientsDTO.ResponseClientDTO;
import pmoc.entities.ClientsEntity;

@RequestMapping("/api/clients")
public interface ClientsController {
    @GetMapping("/{id}")
    ResponseEntity<ClientsEntity> getInfoClient(@PathVariable Long id);

    @GetMapping
    ResponseEntity<Page<PaginateClients>> paginateAllClients(
        @RequestParam(defaultValue = "0") int pageNum,
        @RequestParam(defaultValue = "25") int pageSize
    );

    @PostMapping
    ResponseEntity<ResponseClientDTO> addNewClient(@Valid @RequestBody RequestClientDTO data);

    @PutMapping("/{id}")
    ResponseEntity<ResponseClientDTO> updateClient(@Valid @RequestBody RequestClientDTO data, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteClient(@Valid @PathVariable Long id);
}

package pmoc.controllers;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.entities.OrderEntity;

@RequestMapping("/api/orders")
public interface OrderController {
    @GetMapping
    ResponseEntity<Page<OrderEntity>> pageableAllOrders(
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "25") int pageSize
    );

    @PostMapping
    ResponseEntity<ResponseOrderDTO> createNewOrder(@Valid @RequestBody RequestOrderDTO data);

    @PutMapping("/{id}")
    ResponseEntity<OrderEntity> updateOrder(@Valid @RequestBody RequestOrderDTO data, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable Long id);
}

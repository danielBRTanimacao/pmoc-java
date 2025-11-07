package pmoc.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.controllers.OrderController;
import pmoc.entities.OrderEntity;
import pmoc.mapper.OrderMapper;
import pmoc.services.OrdersService;

@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {
    private final OrdersService ordersService;

    private final OrderMapper orderMapper;

    @Override
    public ResponseEntity<Page<OrderEntity>> pageableAllOrders(int pageNum, int pageSize) {
        return ResponseEntity.ok().body(ordersService.getAllOrders(pageNum, pageSize));
    }

    @Override
    public ResponseEntity<ResponseOrderDTO> createNewOrder(RequestOrderDTO data) {
        OrderEntity preOrder = orderMapper.toEntity(data);
        return new ResponseEntity<>(ordersService.createOrder(preOrder), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<OrderEntity> updateOrder(RequestOrderDTO data, Long id) {
        OrderEntity preOrder = orderMapper.toEntity(data);
        return ResponseEntity.ok().body(ordersService.updtOrder(preOrder , id));
    }

    @Override
    public ResponseEntity<?> deleteOrder(Long id) {
        ordersService.delOrder(id);
        return ResponseEntity.noContent().build();
    }
}

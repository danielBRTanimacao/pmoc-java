package pmoc.services;

import org.springframework.data.domain.Page;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.entities.OrderEntity;

public interface OrdersService {
    Page<OrderEntity> getAllOrders(int pagNum, int pageSize);
    ResponseOrderDTO createOrder(OrderEntity order);
    ResponseOrderDTO updtOrder(OrderEntity data, Long id);
    void delOrder(Long id);
}

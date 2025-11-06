package pmoc.services;

import org.springframework.data.domain.Page;
import pmoc.DTOs.OrderDTO.ResponseOrder;
import pmoc.entities.OrderEntity;

public interface OrdersService {
    Page<OrderEntity> getAllOrders(int pagNum, int pageSize);
    ResponseOrder createOrder(OrderEntity order);
}

package pmoc.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pmoc.DTOs.OrderDTO.ResponseOrder;
import pmoc.entities.ClientsEntity;
import pmoc.entities.OrderEntity;
import pmoc.repositories.ClientsRepository;
import pmoc.repositories.MechanicsRepository;
import pmoc.repositories.OrdersRepository;
import pmoc.services.OrdersService;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;

    @Override
    public Page<OrderEntity> getAllOrders(int pagNum, int pageSize) {
        Pageable pageable = PageRequest.of(pagNum, pageSize);
        return ordersRepository.findAll(pageable);
    }

    @Override
    public ResponseOrder createOrder(OrderEntity order) {
        ordersRepository.save(order);
        return new ResponseOrder(
                order.getClientId().getName(),
                order.getMecId().getName(),
                order.getOrderPosition(),
                order.getPayment()
        );
    }
}

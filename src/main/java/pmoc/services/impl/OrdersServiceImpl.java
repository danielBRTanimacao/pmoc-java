package pmoc.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.entities.OrderEntity;
import pmoc.exceptions.customs.NotFoundException;
import pmoc.mapper.OrderMapper;
import pmoc.repositories.OrdersRepository;
import pmoc.services.OrdersService;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderMapper orderMapper;

    @Override
    public Page<OrderEntity> getAllOrders(int pagNum, int pageSize) {
        Pageable pageable = PageRequest.of(pagNum, pageSize);
        return ordersRepository.findAll(pageable);
    }

    @Override
    public ResponseOrderDTO createOrder(OrderEntity order) {
        ordersRepository.save(order);
        return orderMapper.toDTO(order);
    }

    @Override
    public ResponseOrderDTO updtOrder(OrderEntity data, Long id) {
        OrderEntity order = ordersRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Order with id " + id + " not found")
        );

        order = orderMapper.partialUpdate(order, data);
        ordersRepository.save(order);
        return orderMapper.toDTO(order);
    }

    @Override
    public void delOrder(Long id) {
        OrderEntity order = ordersRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Order with id " + id + " not found")
        );
        ordersRepository.delete(order);
    }
}

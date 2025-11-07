package pmoc.mapper.impl;

import org.springframework.stereotype.Component;
import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.entities.OrderEntity;
import pmoc.mapper.OrderMapper;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderEntity toEntity(RequestOrderDTO data) {
        return null;
    }

    @Override
    public ResponseOrderDTO toDTO(OrderEntity data) {
        return null;
    }

    @Override
    public OrderEntity partialUpdate(RequestOrderDTO dto, OrderEntity entity) {
        return null;
    }
}

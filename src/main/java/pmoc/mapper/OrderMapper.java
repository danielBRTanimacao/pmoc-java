package pmoc.mapper;

import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.entities.OrderEntity;

public interface OrderMapper {
    OrderEntity toEntity(RequestOrderDTO data);
    ResponseOrderDTO toDTO(OrderEntity data);
    OrderEntity partialUpdate(OrderEntity updtEntity, OrderEntity data);
}
package pmoc.mapper;

import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.entities.OrderEntity;

public interface OrderMapper {
    OrderEntity toEntity(RequestOrderDTO data);
}
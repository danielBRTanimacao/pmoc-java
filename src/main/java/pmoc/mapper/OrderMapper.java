package pmoc.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.entities.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity toEntity(RequestOrderDTO data);
    ResponseOrderDTO toDTO(OrderEntity data);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderEntity partialUpdate(RequestOrderDTO dto, @MappingTarget OrderEntity entity);
}

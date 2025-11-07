package pmoc.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.components.FindEntitiesHandler;
import pmoc.entities.OrderEntity;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class OrderMapper {
    protected final FindEntitiesHandler findEntitiesHandler;

    @Mapping(target = "clientId", expression = "java(findEntitiesHandler.findClientById(data.clientId()))")
    @Mapping(target = "mecId", expression = "java(findEntitiesHandler.findMechanicById(data.mecId()))")
    public abstract OrderEntity toEntity(RequestOrderDTO data);

    public abstract ResponseOrderDTO toDTO(OrderEntity data);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract OrderEntity partialUpdate(RequestOrderDTO dto, @MappingTarget OrderEntity entity);
}
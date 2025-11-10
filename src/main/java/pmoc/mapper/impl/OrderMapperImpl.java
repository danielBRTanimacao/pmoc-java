package pmoc.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.components.FindEntitiesHandler;
import pmoc.entities.OrderEntity;
import pmoc.entities.enums.ordered.OrderStatusEnum;
import pmoc.mapper.OrderMapper;

@Component
@RequiredArgsConstructor
public class OrderMapperImpl implements OrderMapper {

    private final FindEntitiesHandler findEntity;

    @Override
    public OrderEntity toEntity(RequestOrderDTO data) {
        if (data == null) {
            return null;
        }

        OrderEntity order = new OrderEntity();
        order.setClientId(findEntity.findClientById(data.clientId()));
        order.setMecId(findEntity.findMechanicById(data.mecId()));
        order.setProblem(data.problem());
        order.setPrice(data.price());
        order.setObservations(data.observations());

        if (data.status() == null) {
            order.setStatus(OrderStatusEnum.PENDING);
        }
        order.setStatus(data.status());

        return order;
    }

    @Override
    public ResponseOrderDTO toDTO(OrderEntity data) {
        if (data == null) {
            return null;
        }
        return new ResponseOrderDTO(
                data.getClientId().getName(),
                data.getMecId().getName(),
                data.getPrice()
        );
    }

    @Override
    public OrderEntity partialUpdate(OrderEntity updtEntity, OrderEntity data) {
        if (data == null) {
            return null;
        }

        if (data.getClientId() != null) {
            updtEntity.setClientId(data.getClientId());
        }
        if (data.getMecId() != null) {
            updtEntity.setMecId(data.getMecId());
        }
        if (data.getProblem() != null) {
            updtEntity.setProblem(data.getProblem());
        }
        if (data.getPrice() != null) {
            updtEntity.setPrice(data.getPrice());
        }
        if (data.getObservations() != null) {
            updtEntity.setObservations(data.getObservations());
        }

        return updtEntity;
    }
}

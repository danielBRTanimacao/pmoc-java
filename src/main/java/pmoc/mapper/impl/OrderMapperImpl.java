package pmoc.mapper.impl;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.components.FindEntitiesHandler;
import pmoc.entities.OrderEntity;
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
        order.setPayment(data.price());
        order.setObservations(data.observations());

        return order;
    }
}

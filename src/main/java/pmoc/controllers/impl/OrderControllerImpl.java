package pmoc.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.components.FindEntitiesHandler;
import pmoc.controllers.OrderController;
import pmoc.entities.OrderEntity;
import pmoc.entities.enums.ordered.OrderStatusEnum;
import pmoc.services.OrdersService;

@RestController
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {
    private final OrdersService ordersService;

    private final FindEntitiesHandler findEntitiesHandler;

    @Override
    public ResponseEntity<Page<OrderEntity>> pageableAllOrders(int pageNum, int pageSize) {
        return ResponseEntity.ok().body(ordersService.getAllOrders(pageNum, pageSize));
    }

    @Override
    public ResponseEntity<ResponseOrderDTO> createNewOrder(RequestOrderDTO data) {
        OrderEntity preOrder = new OrderEntity();

        preOrder.setClientId(findEntitiesHandler.findClientById(data.clientId()));
        preOrder.setMecId(findEntitiesHandler.findMechanicById(data.mecId()));
        preOrder.setProblem(data.problem());
        preOrder.setPayment(data.value());

        preOrder.setStatus(OrderStatusEnum.PENDING);

        return ResponseEntity.ok().body(ordersService.createOrder(preOrder));
    }
}

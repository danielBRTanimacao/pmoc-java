package pmoc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import pmoc.entities.enums.ordered.OrderStatusEnum;
import pmoc.entities.extension.EquipamentsEntity;

@Entity
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ClientsEntity clientId;
    private MechaniciansEntity mecId;

    private OrderStatusEnum status;

    private Long position;
    private String problem;

    private EquipamentsEntity equipaments_id;

    private String observations;
}

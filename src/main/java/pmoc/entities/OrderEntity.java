package pmoc.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

    @OneToOne
    private ClientsEntity clientId;
    @OneToOne
    private MechaniciansEntity mecId;

    private OrderStatusEnum status;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long position;
    private String problem;

    @OneToOne
    private EquipamentsEntity equipaments_id;

    private BigDecimal value;

    private String observations;
}

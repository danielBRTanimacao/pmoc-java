package pmoc.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import pmoc.entities.enums.ordered.OrderStatusEnum;

@Entity
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private ClientsEntity clientId;
    @ManyToOne
    @JsonBackReference
    private MechaniciansEntity mecId;

    private OrderStatusEnum status;

    private Long position;
    private String problem;

    private BigDecimal value;

    private String observations;
}

package pmoc.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
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

    @ManyToOne(optional = false)
    @JsonBackReference
    private ClientsEntity clientId;
    @ManyToOne
    @JsonBackReference
    private MechanicsEntity mecId;

    private OrderStatusEnum status;

    private Long orderPosition;
    private String problem;

    private BigDecimal price;

    private String observations;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @PrePersist
    void onCreate() {
        this.setStatus(OrderStatusEnum.PENDING);
        this.orderPosition = this.id + 1L;

        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }
}

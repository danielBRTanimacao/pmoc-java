package pmoc.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClientsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phone;
    
    private String address;
    private String room;
    private String department;

    @OneToOne
    private OrderEntity order_id;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @PrePersist
    void onCreate(){
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }
}

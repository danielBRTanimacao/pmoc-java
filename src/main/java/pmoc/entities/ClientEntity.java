package pmoc.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne()
    private AdressesEntity adress;
    
    private LocalDateTime date;
    private String applicant;
    private String position;
    private String phone;

    private String equipment_name;
    private String voltage;
    private String temperature;
    private String gas_preassure;

    @OneToOne()
    private AcessoriesEntity acessory;

    private String observations;
    private String signature;
}

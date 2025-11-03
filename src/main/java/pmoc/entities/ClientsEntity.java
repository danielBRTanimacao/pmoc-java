package pmoc.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import pmoc.entities.extension.AcessoriesEntity;
import pmoc.entities.extension.AddressesEntity;

@Entity
@Getter
@Setter
public class ClientsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phone;

    @OneToOne
    private AddressesEntity address;
    
    @OneToOne
    private AcessoriesEntity acessory;
    
    private LocalDateTime date;
    private String observations;
}

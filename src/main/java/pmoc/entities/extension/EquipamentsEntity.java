package pmoc.entities.extension;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import pmoc.entities.ClientsEntity;

@Entity
@Getter
@Setter
public class EquipamentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private ClientsEntity client;

    private boolean filter;
    private boolean diffusers;
    private boolean equipments;
}

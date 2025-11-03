package pmoc.entities.extension;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import pmoc.entities.ClientEntity;

@Entity
@Getter
@Setter
public class AcessoriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private ClientEntity client;

    private boolean filter;
    private boolean cabinet;
    private boolean evaporator;
    private boolean grukks;
    private boolean diffusers;
    private boolean bactericidal;
    private boolean paletts;
    private boolean remote_control;
    private boolean equipments;
    private boolean cracks;
}

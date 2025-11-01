package pmoc.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String adress;
    private String building;

    private String room;
    private String to_walk;
    private String department;
    
    private LocalDateTime date;
    private String applicant;
    private String position;
    private String phone;

    private String equipment_name;
    private String voltage;
    private String temperature;
    private String gas_preassure;

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

    private String observations;
    private String signature;
}

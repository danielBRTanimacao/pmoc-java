package pmoc.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import pmoc.entities.enums.SignaturesEnum;
import pmoc.entities.enums.StatusEnum;

@Entity
@Getter
@Setter
public class ManagersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String email;
    private String passsword;
    private String token;

    private StatusEnum status;
    private SignaturesEnum signature;

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

    public boolean checkIsExpirated() {
        LocalDateTime max_time = this.created_at.plusMinutes(30);
        LocalDateTime time_actual = LocalDateTime.now();

        return time_actual.isAfter(max_time);
    }
}

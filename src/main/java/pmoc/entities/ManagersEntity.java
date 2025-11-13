package pmoc.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pmoc.entities.enums.manager.SignaturesEnum;
import pmoc.entities.enums.manager.StatusEnum;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class ManagersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String token;

    private StatusEnum status;
    private SignaturesEnum signature;

    @CreatedDate
    private LocalDateTime created_at;
    @LastModifiedDate
    private LocalDateTime updated_at;

    public boolean isExpiredToken() {
        LocalDateTime max_time = this.created_at.plusMinutes(30);
        LocalDateTime time_actual = LocalDateTime.now();

        return time_actual.isAfter(max_time);
    }
}

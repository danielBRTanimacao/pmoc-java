package pmoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pmoc.entities.OrderEntity;

public interface OrdersRepository extends JpaRepository<OrderEntity, Long> {
}

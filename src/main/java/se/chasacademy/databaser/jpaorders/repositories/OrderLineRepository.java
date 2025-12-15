package se.chasacademy.databaser.jpaorders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.chasacademy.databaser.jpaorders.models.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine,Long> {
}

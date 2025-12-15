package se.chasacademy.databaser.jpaorders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.chasacademy.databaser.jpaorders.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}

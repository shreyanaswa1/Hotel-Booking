package main.repository;

import main.entity.payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<payment,Integer> {
}

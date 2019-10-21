package main.repository;

import main.entity.reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<reservation,Integer> {
}

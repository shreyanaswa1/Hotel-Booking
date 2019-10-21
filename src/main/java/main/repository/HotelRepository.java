package main.repository;

import main.entity.hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<hotel, Integer> {
}

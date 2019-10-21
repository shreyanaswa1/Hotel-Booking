package main.repository;

import main.entity.room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<room,Integer> {
}

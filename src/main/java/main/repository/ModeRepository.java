package main.repository;

import main.entity.mode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeRepository extends JpaRepository<mode,Integer> {
}

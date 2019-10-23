package main.repository;

import main.entity.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeRepository extends JpaRepository<Mode,Integer> {


}

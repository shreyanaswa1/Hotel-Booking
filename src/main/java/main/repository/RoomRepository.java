package main.repository;

import main.entity.Hotel;
import main.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
//    public String create(@RequestBody Hotel hotel,int id);

}

package main.service;

import main.entity.Room;
import main.repository.RoomRepository;
import main.request.RoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomRequest> findAll(){
        List<Room> roomList = roomRepository.findAll();
        List<RoomRequest> roomRequests = new ArrayList<RoomRequest>();
        for(Room rooms: roomList){
            RoomRequest roomRequest = new RoomRequest();
            roomRequest.setId(rooms.getId());
            roomRequest.setType(rooms.getType());
            roomRequest.setCount(rooms.getCount());
            roomRequest.setRate(rooms.getRate());
            roomRequests.add(roomRequest);
        }
        return roomRequests;

    }
    public RoomRequest findbyId(int id){
        Optional<Room> rooms = roomRepository.findById(id);
        RoomRequest roomRequest = new RoomRequest();
        if(rooms.isPresent()){
            roomRequest.setId(rooms.get().getId());
            roomRequest.setType(rooms.get().getType());
            roomRequest.setCount(rooms.get().getCount());
            roomRequest.setRate(rooms.get().getRate());
        }
        return roomRequest;
    }

//    public String create(RoomRequest roomRequest){
//        Room room = new Room();
//        room.setId(roomRequest.getId());
//        room.setType(roomRequest.getType());
//        room.setCount(roomRequest.getCount());
//        room.setRate(roomRequest.getRate());
//        return "Success";
//    }

}

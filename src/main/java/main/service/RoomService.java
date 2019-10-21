package main.service;

import main.entity.room;
import main.repository.RoomRepository;
import main.request.RoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<RoomRequest> findAll(){
        List<room> roomList = roomRepository.findAll();
        List<RoomRequest> roomRequests = new ArrayList<RoomRequest>();
        for(room rooms: roomList){
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
        room rooms = roomRepository.findOne(id);
        RoomRequest roomRequest = new RoomRequest();
        roomRequest.setId(rooms.getId());
        roomRequest.setType(rooms.getType());
        roomRequest.setCount(rooms.getCount());
        roomRequest.setRate(rooms.getRate());
        return roomRequest;
    }

}

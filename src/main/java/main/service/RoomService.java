package main.service;

import main.entity.Hotel;
import main.entity.Room;
import main.repository.HotelRepository;
import main.repository.RoomRepository;
import main.request.HotelRequest;
import main.request.RoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;

    public List<RoomRequest> findAll() {
        List<Room> roomList = roomRepository.findAll();
        List<RoomRequest> roomRequests = new ArrayList<RoomRequest>();
        for (Room rooms : roomList) {
            RoomRequest roomRequest = new RoomRequest();
            roomRequest.setId(rooms.getId());
            roomRequest.setType(rooms.getType());
            roomRequest.setCount(rooms.getCount());
            roomRequest.setRate(rooms.getRate());
            roomRequest.setHotels(rooms.getHotels());
            roomRequests.add(roomRequest);
        }
        return roomRequests;

    }

    public RoomRequest findbyId(int id) {
        Optional<Room> rooms = roomRepository.findById(id);
        RoomRequest roomRequest = new RoomRequest();
        if (rooms.isPresent()) {
            roomRequest.setId(rooms.get().getId());
            roomRequest.setType(rooms.get().getType());
            roomRequest.setCount(rooms.get().getCount());
            roomRequest.setRate(rooms.get().getRate());
            roomRequest.setHotels(rooms.get().getHotels());
        }
        return roomRequest;
    }

    public String create(@RequestBody HotelRequest hotelRequest,int id) {
        Hotel hotel = hotelRepository.findById(id).get();

        //hotelRequest.setId(hotel.getId());
        if (hotelRequest.getRoomRequest() != null) {
            List<Room> roomRequests = new ArrayList<>();
            for (RoomRequest roomReques : hotelRequest.getRoomRequest()) {
                Room room = new Room();
                room.setId(roomReques.getId());
                room.setType(roomReques.getType());
                room.setCount(roomReques.getCount());
                room.setRate(roomReques.getRate());
                roomRequests.add(room);
                roomRepository.save(room);
            }
            //hotel.setRoomList(roomRequests);
        }
    return"Success";
}

}

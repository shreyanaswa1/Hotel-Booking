package main.service;

import main.entity.Hotel;
import main.entity.Room;
import main.repository.HotelRepository;
import main.repository.RoomRepository;
import main.request.HotelRequest;
import main.request.RoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;


    public RoomRequest getRoomRequest(Room rooms)
    {
        RoomRequest roomRequest=new RoomRequest();
        roomRequest.setId(rooms.getId());
        roomRequest.setType(rooms.getType());
        roomRequest.setRate(rooms.getRate());
        roomRequest.setCount(rooms.getCount());
        return roomRequest;
    }

    public HotelRequest getHotelRequest(Hotel hotels)
    {
        HotelRequest hotelRequest=new HotelRequest();
        List<RoomRequest> roomRequestsList=new ArrayList<>();
        hotelRequest.setId(hotels.getId());
        hotelRequest.setName(hotels.getName());
        hotelRequest.setAddress(hotels.getAddress());
        hotelRequest.setPhone(hotels.getPhone());
        for(Room rooom:hotels.getRoomList())
        {
            roomRequestsList.add(getRoomRequest(rooom));
        }
        hotelRequest.setRoomRequest(roomRequestsList);
        return hotelRequest;
    }


    public List<HotelRequest> findAll() {
        List<Hotel> hotelList = hotelRepository.findAll();
        List<HotelRequest> hotelRequests = new ArrayList<HotelRequest>();
        for(Hotel hotel: hotelList){

            HotelRequest hotelRequest = new HotelRequest();
            hotelRequest.setId(hotel.getId());
            hotelRequest.setName(hotel.getName());
            hotelRequest.setPhone(hotel.getPhone());
            hotelRequest.setAddress(hotel.getAddress());
            hotelRequests.add(hotelRequest);
        }

        return hotelRequests;

    }
        public List<Room> findRoom(int id){
             Hotel hotel=hotelRepository.findById(id).get();
            return hotelRepository.getRoomList(hotel);
        }


    public HotelRequest findbyId(int id){
        Optional <Hotel> hotels  = hotelRepository.findById(id);
        HotelRequest hotelRequest = new HotelRequest();
        if(hotels.isPresent()){
            hotelRequest.setId(hotels.get().getId());
            hotelRequest.setName(hotels.get().getName());
            hotelRequest.setPhone(hotels.get().getPhone());
            hotelRequest.setAddress(hotels.get().getAddress());
        }

        return hotelRequest;
    }

    public HotelRequest findDetails(int id){
        Hotel hotels = hotelRepository.findById(id).get();
        HotelRequest hotelRequest = getHotelRequest(hotels);
        return hotelRequest;

    }

//    public String create(@RequestBody HotelRequest hotelRequest){
//        Hotel hotel=new Hotel();
//        hotel.setId(hotelRequest.getId());
//        hotel.setName(hotelRequest.getName());
//        hotel.setPhone(hotelRequest.getPhone());
//        hotel.setAddress(hotelRequest.getAddress());
//
//       // System.out.println(hotelRequest);
//       // if(hotelRequest.getRoomRequest()!=null){
//        List<Room> roomRequests=new ArrayList<>();
//            for(RoomRequest roomRequest:hotelRequest.getRoomRequest()){
//
//                Room room = new Room();
//                room.setId(roomRequest.getId());
//                room.setType(roomRequest.getType());
//                room.setCount(roomRequest.getCount());
//                room.setRate(roomRequest.getRate());
//             //   hotel.setRoomList();
//              roomRequests.add(room);
//                //roomRequests.a
//                roomRepository.save(room);
//
//            }
//            hotel.setRoomList(roomRequests);
//             hotelRepository.save(hotel);
//       // }
//
//        return "Success";
//    }
    }


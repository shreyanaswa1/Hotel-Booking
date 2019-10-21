package main.service;

import main.entity.hotel;
import main.repository.HotelRepository;
import main.request.HotelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public List<HotelRequest> findAll(){
        List<hotel> hotelList = hotelRepository.findAll();
        List<HotelRequest> hotelRequests = new ArrayList<HotelRequest>();
        for(hotel hotels: hotelList){
            HotelRequest hotelRequest = new HotelRequest();
            hotelRequest.setId(hotels.getId());
            hotelRequest.setName(hotels.getName());
            hotelRequest.setPhone(hotels.getPhone());
            hotelRequest.setAddress(hotels.getAddress());
            hotelRequests.add(hotelRequest);

        }
        return hotelRequests;

    }
    public HotelRequest findbyId(int id){
        hotel hotels = hotelRepository.findOne(id);
        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setId(hotels.getId());
        hotelRequest.setName(hotels.getName());
        hotelRequest.setPhone(hotels.getPhone());
        hotelRequest.setAddress(hotels.getAddress());


        return hotelRequest;



    }
}

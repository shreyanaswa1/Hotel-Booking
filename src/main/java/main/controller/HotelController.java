package main.controller;

import main.entity.Hotel;
import main.entity.Room;
import main.request.HotelRequest;
import main.request.RoomRequest;
import main.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    public HotelService hotelService;

    @GetMapping(path = {"/all"})
    public List<HotelRequest> findAll() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public HotelRequest findById(@PathVariable("id") int id)
    {
        return hotelService.findbyId(id);
    }

    @GetMapping("/{id}/room")
    public HotelRequest findbyId(@PathVariable("id") int id)
    {
        return hotelService.findDetails(id);
    }

    @PostMapping
    public String create(@RequestBody HotelRequest hotelRequest){
        return hotelService.create(hotelRequest);
    }

     @GetMapping("{id}/rooms")
     public List<Room> find(@PathVariable("id")int id)
     {
//         Hotel hotel=hotelService.findbyId(id);
         return hotelService.findRoom(id);
     }

//     @GetMapping("/{id}/room")
//    public List<Room> findbyId()
//    {
//    return hotelService.findRoom(id);
//    }
}

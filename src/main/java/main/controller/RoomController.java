package main.controller;

import main.request.HotelRequest;
import main.request.RoomRequest;
import main.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    public RoomService roomService;


    @GetMapping("/all")
    public List<RoomRequest> findAll() {
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    public RoomRequest findById(@PathVariable("id") int id) {
        return roomService.findbyId(id);
    }

    @PostMapping("/{id}")
    public String create(@RequestBody HotelRequest hotelRequest,@PathVariable("id") int id)

   {

        return roomService.create(hotelRequest,id);
    }

}

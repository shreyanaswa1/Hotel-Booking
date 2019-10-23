package main.controller;

import main.request.RoomRequest;
import main.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

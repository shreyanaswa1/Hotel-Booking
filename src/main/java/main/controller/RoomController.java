package main.controller;

import main.request.RoomRequest;
import main.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class RoomController {
    @Autowired
    public RoomService roomService;


    @GetMapping("/all")
    public List<RoomRequest> findAll() {
        return roomService.findAll();
    }
    @GetMapping("/{id}")
    public RoomRequest findOne(@PathVariable("id") int id)
    {
        return roomService.findbyId(id);
    }

}

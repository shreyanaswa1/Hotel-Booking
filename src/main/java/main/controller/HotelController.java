package main.controller;

import main.request.HotelRequest;
import main.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    public HotelService hotelService;
    @GetMapping("/all")
    public List<HotelRequest> findAll() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public HotelRequest findOne(@PathVariable("id") int id)
    {
        return hotelService.findbyId(id);
    }
}

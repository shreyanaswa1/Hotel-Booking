package main.controller;

import main.request.GuestRequest;
import main.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/guest"})
public class GuestController {

    @Autowired
    public GuestService guestService;


    @GetMapping("/all")
    public List<GuestRequest> findAll() {

        return guestService.findAll();
    }

    @GetMapping("/{id}")
    public GuestRequest findbyId(@PathVariable("id") int id)
    {
        return guestService.findbyId(id);
    }

    @GetMapping("/{id}/reservation")
    public GuestRequest findById(@PathVariable("id") int id)
    {
        return guestService.findReservation(id);
    }

    @PostMapping
    public String create(@RequestBody GuestRequest guestRequest)
    {

        return guestService.create(guestRequest);
    }

}

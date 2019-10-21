package main.controller;

import main.request.GuestRequest;
import main.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    public GuestService guestService;


    @GetMapping("/all")
    public List<GuestRequest> findAll() {
        return guestService.findAll();
    }
    @GetMapping("/{id}")
    public GuestRequest findOne(@PathVariable("id") int id)
    {
        return guestService.findbyId(id);
    }

}

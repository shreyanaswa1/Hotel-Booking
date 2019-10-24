package main.controller;

import main.request.ReservationRequest;
import main.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    public ReservationService reservationService;


    @GetMapping("/all")
    public List<ReservationRequest> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ReservationRequest findById(@PathVariable("id") int id) {
        return reservationService.findbyId(id);
    }

//    @PostMapping
//    public String create(ReservationRequest reservationRequest){
//        return reservationService.create(reservationRequest);
//    }

}

package main.service;

import main.entity.guest;
import main.request.GuestRequest;
import main.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {

    @Autowired
    GuestRepository repository;


    public List<GuestRequest> findAll(){

        List<guest> guestList = repository.findAll();
        List<GuestRequest> guestRequests = new ArrayList<GuestRequest>();
        for(guest guest: guestList){

            GuestRequest guestRequest = new GuestRequest();
            guestRequest.setId(guest.getId());
            guestRequest.setName(guest.getName());
            guestRequest.setAadhar(guest.getAadhar());
            guestRequest.setEmail_id(guest.getEmail_id());
            guestRequest.setAddress(guest.getAddress());
            guestRequests.add(guestRequest);
        }

        return guestRequests;

    }
    public GuestRequest findbyId(int id){
        guest guests = repository.findOne(id);
        GuestRequest guestRequest = new GuestRequest();
        guestRequest.setId(guests.getId());
        guestRequest.setName(guests.getName());
        guestRequest.setAadhar(guests.getAadhar());
        guestRequest.setAddress(guests.getAddress());
        guestRequest.setEmail_id(guests.getEmail_id());

        return guestRequest;



    }



}

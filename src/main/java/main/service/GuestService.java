package main.service;

import main.entity.Guest;
import main.entity.Reservation;
import main.request.GuestRequest;
import main.repository.GuestRepository;
import main.request.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    public GuestRepository repository;


    public ReservationRequest getReservationRequest(Reservation reservation)
    {
        ReservationRequest reservationRequest=new ReservationRequest();
        reservationRequest.setId(reservation.getId());
        reservationRequest.setTotalRooms(reservation.getTotalRooms());
        reservationRequest.setAmount(reservation.getAmount());
        reservationRequest.setStartDate(reservation.getStartDate());
        reservationRequest.setEndDate(reservation.getEndDate());

        return reservationRequest;
    }
    public GuestRequest getGuestRequest(Guest guests)
    {
        GuestRequest guestRequest=new GuestRequest();
        List<ReservationRequest> reservationRequestsList=new ArrayList<>();
        guestRequest.setId(guests.getId());
        guestRequest.setName(guests.getName());
        guestRequest.setAddress(guests.getAddress());
        guestRequest.setAadhar(guests.getAadhar());
        guestRequest.setEmailId(guests.getEmailId());
        for(Reservation reservations:guests.getReservationList()) {
            reservationRequestsList.add(getReservationRequest(reservations));
        }
        guestRequest.setReservationRequest(reservationRequestsList);
        return guestRequest;
    }
    public List<GuestRequest> findAll(){

        List<Guest> guestList = repository.findAll();
        List<GuestRequest> guestRequests = new ArrayList<GuestRequest>();
        for(Guest guest: guestList) {
            GuestRequest guestRequest = new GuestRequest();
            guestRequest.setId(guest.getId());
            guestRequest.setName(guest.getName());
            guestRequest.setAadhar(guest.getAadhar());
            guestRequest.setEmailId(guest.getEmailId());
            guestRequest.setAddress(guest.getAddress());
            guestRequests.add(guestRequest);
        }
        return guestRequests;
    }

    public GuestRequest findbyId(int id) {
        Optional<Guest> guests = repository.findById(id);
        GuestRequest guestRequest = new GuestRequest();
        if(guests.isPresent()){
            guestRequest.setId(guests.get().getId());
            guestRequest.setName(guests.get().getName());
            guestRequest.setAadhar(guests.get().getAadhar());
            guestRequest.setEmailId(guests.get().getEmailId());
            guestRequest.setAddress(guests.get().getAddress());
        }

        return guestRequest;
    }

    public GuestRequest findReservation(int id) {
       Guest guests = repository.findById(id).get();

           GuestRequest guestRequest = getGuestRequest(guests);

       return guestRequest;
    }


    public ResponseEntity<String> create(GuestRequest guestRequest) {
        Guest guest = new Guest();
        guest.setId(guestRequest.getId());
        guest.setName(guestRequest.getName());
        guest.setAadhar(guestRequest.getAadhar());
        guest.setEmailId(guestRequest.getEmailId());
        guest.setAddress(guestRequest.getAddress());
        repository.save(guest);
        return new ResponseEntity<>("CREATED", HttpStatus.CREATED);
    }



}

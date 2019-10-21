package main.service;

import main.entity.reservation;
import main.repository.ReservationRepository;
import main.request.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<ReservationRequest> findAll(){
        List<reservation> reservationList = reservationRepository.findAll();
        List<ReservationRequest> reservationRequests = new ArrayList<ReservationRequest>();
        for(reservation reservations: reservationList){
            ReservationRequest reservationRequest = new ReservationRequest();
            reservationRequest.setId(reservations.getId());
            reservationRequest.setStart_date(reservations.getStart_date());
            reservationRequest.setEnd_date(reservations.getEnd_date());
            reservationRequest.setAmount(reservations.getAmount());

            reservationRequests.add(reservationRequest);

        }
        return reservationRequests;

    }
    public ReservationRequest findbyId(int id){
        reservation reservations = reservationRepository.findOne(id);
        ReservationRequest reservationRequest = new ReservationRequest();
        reservationRequest.setId(reservations.getId());
        reservationRequest.setStart_date(reservations.getStart_date());
        reservationRequest.setEnd_date(reservations.getEnd_date());
        reservationRequest.setAmount(reservations.getAmount());
        return reservationRequest;
    }
}

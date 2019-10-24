package main.service;

import main.entity.Reservation;
import main.repository.ReservationRepository;
import main.request.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationRequest> findAll(){
        List<Reservation> reservationList = reservationRepository.findAll();
        List<ReservationRequest> reservationRequests = new ArrayList<ReservationRequest>();
        for(Reservation reservations: reservationList){
            ReservationRequest reservationRequest = new ReservationRequest();
            reservationRequest.setId(reservations.getId());
            reservationRequest.setTotal_rooms(reservations.getTotalRooms());
            reservationRequest.setStartDate(reservations.getStartDate());
            reservationRequest.setEndDate(reservations.getEndDate());
            reservationRequest.setAmount(reservations.getAmount());

            reservationRequests.add(reservationRequest);

        }
        return reservationRequests;

    }
    public ReservationRequest findbyId(int id){
        Optional<Reservation> reservations = reservationRepository.findById(id);
        ReservationRequest reservationRequest = new ReservationRequest();
        if(reservations.isPresent()){
            reservationRequest.setId(reservations.get().getId());
            reservationRequest.setTotal_rooms(reservations.get().getTotalRooms());
            reservationRequest.setStartDate(reservations.get().getStartDate());
            reservationRequest.setEndDate(reservations.get().getEndDate());
            reservationRequest.setAmount(reservations.get().getAmount());
        }

        return reservationRequest;
    }

//    public String create(ReservationRequest reservationRequest){
//        Reservation reservation = new Reservation();
//        reservation.setId(reservationRequest.getId());
//        reservation.setAmount(reservationRequest.getAmount());
//        reservation.setTotalRooms(reservationRequest.getTotal_rooms());
//        reservation.setStartDate(reservationRequest.getStartDate());
//        reservation.setEndDate(reservationRequest.getEndDate());
//        return "Success";
//    }
}

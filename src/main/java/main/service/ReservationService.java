package main.service;

import main.entity.Guest;
import main.entity.Reservation;
import main.entity.Room;
import main.repository.GuestRepository;
import main.repository.ReservationRepository;
import main.repository.RoomRepository;
import main.request.ReservationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private  static Logger logger= LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<ReservationRequest> findAll(){
        List<Reservation> reservationList = reservationRepository.findAll();
        List<ReservationRequest> reservationRequests = new ArrayList<ReservationRequest>();
        for(Reservation reservations: reservationList){
            ReservationRequest reservationRequest = new ReservationRequest();
            reservationRequest.setId(reservations.getId());
            reservationRequest.setTotalRooms(reservations.getTotalRooms());
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
            reservationRequest.setTotalRooms(reservations.get().getTotalRooms());
            reservationRequest.setStartDate(reservations.get().getStartDate());
            reservationRequest.setEndDate(reservations.get().getEndDate());
            reservationRequest.setAmount(reservations.get().getAmount());


        }

        return reservationRequest;
    }



    public String create(ReservationRequest reservationRequest){
        try {
            Reservation reservation = new Reservation();
//        reservation.setId(reservationRequest.getId());
            reservation.setAmount(reservationRequest.getAmount());
            reservation.setTotalRooms(reservationRequest.getTotalRooms());
            reservation.setStartDate(reservationRequest.getStartDate());
            reservation.setEndDate(reservationRequest.getEndDate());
            Guest guest = guestRepository.findById(reservationRequest.getGuestId()).get();
            Room room = roomRepository.findById(reservationRequest.getRoomId()).get();
            reservation.setGuests(guest);
            reservation.setRoom(room);
            reservationRepository.save(reservation);
            return "Success";
        }
        catch (Exception e)
        {
            logger.error("The exception thrown is {}",e);
            return "Failed";
        }

    }

    public String update(int id,ReservationRequest reservationRequest){
        Reservation reservation = reservationRepository.findById(id).get();
        reservation.setStartDate(reservation.getStartDate());
        reservation.setEndDate(reservation.getEndDate());
        reservation.setTotalRooms(reservation.getTotalRooms());
        reservationRepository.save(reservation);
        return "Updated";

    }
}

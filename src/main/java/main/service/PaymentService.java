package main.service;

import main.entity.Payment;
import main.entity.Reservation;
import main.repository.PaymentRepository;
import main.repository.ReservationRepository;
import main.request.PaymentRequest;
import main.request.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<PaymentRequest> findAll(){
        List<Payment> paymentList = paymentRepository.findAll();
        List<PaymentRequest> paymentRequests = new ArrayList<PaymentRequest>();
        for(Payment payments: paymentList){
            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setId(payments.getId());
            paymentRequest.setAmount(payments.getAmount());
            paymentRequest.setDate(payments.getDate());
            paymentRequests.add(paymentRequest);
        }
        return paymentRequests;

    }

    public PaymentRequest findbyId(int id){
        Optional<Payment> payments = paymentRepository.findById(id);
        PaymentRequest paymentRequest = new PaymentRequest();
        if(payments.isPresent()){
            paymentRequest.setId(payments.get().getId());
            paymentRequest.setAmount(payments.get().getAmount());
        }

        return paymentRequest;
    }

    public ReservationRequest getReservationRequest(Reservation reservation){

        ReservationRequest reservationRequest = new ReservationRequest();
        reservationRequest.setId(reservation.getId());
        reservationRequest.setTotalRooms(reservation.getTotalRooms());
        reservationRequest.setAmount(reservation.getAmount());
        reservationRequest.setStartDate(reservation.getStartDate());
        reservationRequest.setEndDate(reservation.getEndDate());
        return reservationRequest;
    }

    public PaymentRequest findDetails(int id){
        Optional<Payment> payments = paymentRepository.findById(id);
        PaymentRequest paymentRequest = new PaymentRequest();
        if(payments.isPresent()){
            paymentRequest.setId(payments.get().getId());
            paymentRequest.setDate(payments.get().getDate());
            paymentRequest.setAmount(payments.get().getAmount());
            paymentRequest.setReservationRequest(getReservationRequest(payments.get().getReservation()));
        }

        return paymentRequest;

    }

    public String create(PaymentRequest paymentRequest){
        Payment payment = new Payment();
        payment.setId(paymentRequest.getId());
        payment.setAmount(paymentRequest.getAmount());
        payment.setDate(paymentRequest.getDate());
        paymentRepository.save(payment);
//        Reservation reservation = reservationRepository.findById(paymentRequest.getReservationId()).get();
        return "Success";
    }
}

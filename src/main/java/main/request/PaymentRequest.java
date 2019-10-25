package main.request;

import main.entity.Reservation;

import java.util.Date;

public class PaymentRequest {

    private Integer id;
    private Integer amount;
    private Date date;
    private Integer reservationId;
    private ReservationRequest reservationRequest;

    public ReservationRequest getReservationRequest() {
        return reservationRequest;
    }

    public void setReservationRequest(ReservationRequest reservationRequest) {
        this.reservationRequest = reservationRequest;
    }

//    public Integer getReservationId() {
//        return reservationId;
//    }
//
//    public void setReservationId(Integer reservationId) {
//        this.reservationId = reservationId;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

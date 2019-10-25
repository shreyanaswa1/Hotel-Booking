package main.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer id;

    @Column(name="total_rooms")
    private Integer totalRooms;
    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;
    @Column(name="amount")
    private Integer amount;

//    @OneToOne(mappedBy = "reservation")
//    private Payment payment;

    @ManyToOne
    @JoinColumn(name="guest_id")
    private Guest guests;

    @ManyToOne
    @JoinColumn(name="room_id")
    private  Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }



    public Guest getGuests() {
        return guests;
    }

    public void setGuests(Guest guests) {
        this.guests = guests;
    }

//    @OneToOne
//    @JoinColumn(referencedColumnName = "id", name="hotel_id")
//    private Hotel hotel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


//    public Payment getPayment() {
//        return payment;
//    }
//
//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }

}

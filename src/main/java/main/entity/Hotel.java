package main.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer phone;
    @Column
    private String address;

    @OneToMany(mappedBy ="hotels")
    private List<Room> roomList;

//    @OneToOne(mappedBy="hotel")
//    private Reservation reservation;
//
//    public Reservation getReservation() {
//        return reservation;
//    }
//
//    public void setReservation(Reservation reservation) {
//        this.reservation = reservation;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}

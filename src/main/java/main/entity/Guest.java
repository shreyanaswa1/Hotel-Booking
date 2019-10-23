package main.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer aadhar;

    @Column
    private String emailId;

    @Column
    private String address;

    @OneToMany(mappedBy ="guests")
    private List<Reservation> reservationList;

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAadhar() {
        return aadhar;
    }

    public void setAadhar(Integer aadhar) {
        this.aadhar = aadhar;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

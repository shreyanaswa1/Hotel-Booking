package main.request;

import java.util.List;

public class GuestRequest {

    private Integer id;
    private String name;
    private Integer aadhar;
    private String emailId;
    private String address;
    private List<ReservationRequest> reservationRequest;

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

    public Integer getAadhar() {
        return aadhar;
    }

    public void setAadhar(Integer aadhar) {
        this.aadhar = aadhar;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ReservationRequest> getReservationRequest() {
        return reservationRequest;
    }

    public void setReservationRequest(List<ReservationRequest> reservationRequest) {
        this.reservationRequest = reservationRequest;
    }
}

package main.request;

import java.util.List;
import main.request.RoomRequest;

public class HotelRequest {
    private Integer id;
    private String name;
    private Integer phone;
    private String address;
    private List<RoomRequest> roomRequest;

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

    public List<RoomRequest> getRoomRequest() {
        return roomRequest;
    }

    public void setRoomRequest(List<RoomRequest> roomRequest) {
        this.roomRequest = roomRequest;
    }
}

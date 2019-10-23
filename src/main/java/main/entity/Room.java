package main.entity;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String type;
    @Column
    private Integer count;
    @Column
    private Integer rate;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name="hotel_id")
    private Hotel hotels;

    public Hotel getHotels() {
        return hotels;
    }

    public void setHotels(Hotel hotels) {
        this.hotels = hotels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}

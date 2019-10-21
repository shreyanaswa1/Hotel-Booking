package main.entity;

import javax.persistence.*;

@Entity
@Table(name="room")
public class room {

    @Id
    private int id;
    @Column
    private String type;
    @Column
    private int count;
    @Column
    private int rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}

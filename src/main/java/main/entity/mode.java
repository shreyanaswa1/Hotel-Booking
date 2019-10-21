package main.entity;

import javax.persistence.*;

@Entity
@Table(name="mode")
public class mode {

    @Id
    private int id;
    @Column
    private String type;

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
}

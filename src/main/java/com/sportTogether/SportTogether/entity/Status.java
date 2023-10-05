package com.sportTogether.SportTogether.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column
    private String name ;

    @OneToMany(mappedBy = "status")
    private Set<Orders> listOrders;

    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    public Status() {
    }

    public Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

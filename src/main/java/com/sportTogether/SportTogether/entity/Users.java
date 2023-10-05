package com.sportTogether.SportTogether.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name= "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id ;

    @Column
    private String name ;
    @Column
    private String email;
    @Column
    private String password ;

    @Column
    private String number ;

    @OneToMany(mappedBy = "users")
    private Set<Orders> listOrders;


    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Users() {
    }

    public Users(int id, String name, String email, String password, String number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

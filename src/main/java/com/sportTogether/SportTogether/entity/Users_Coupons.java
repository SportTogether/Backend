package com.sportTogether.SportTogether.entity;

import javax.persistence.*;

@Entity(name = "users_coupons")
public class Users_Coupons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    @Column
    private String name ;
    @Column
    private int users_id ;
    @Column
    private int coupons_id;


    public Users_Coupons(int id, String name, int users_id, int coupons_id) {
        this.id = id;
        this.name = name;
        this.users_id = users_id;
        this.coupons_id = coupons_id;
    }

    public Users_Coupons() {
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

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getCoupons_id() {
        return coupons_id;
    }

    public void setCoupons_id(int coupons_id) {
        this.coupons_id = coupons_id;
    }
}

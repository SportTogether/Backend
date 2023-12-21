package com.sportTogether.SportTogether.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users_coupons")
public class Users_Coupons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;


    @ManyToOne
    @JoinColumn(name = "users_id")
    public Users users;

    @ManyToOne
    @JoinColumn(name = "coupons_id")
    public Coupons coupons;

    public Users_Coupons( Users user, Coupons coupon) {

        this.users = user;
        this.coupons = coupon;


    }

    public Users_Coupons() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users user) {
        this.users = user;
    }

    public Coupons getCoupon() {
        return coupons;
    }

    public void setCoupon(Coupons coupon) {
        this.coupons = coupon;
    }
}

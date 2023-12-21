package com.sportTogether.SportTogether.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "coupons")
public class Coupons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id ;

    @Column
    public String name ;
    @Column
    public String description ;

    @Column
    public String icon ;

    @Column
    public int discount ;

    @OneToMany(mappedBy = "coupons")
    private Set<Users_Coupons> listUserCoupon;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Coupons() {
    }

    public Coupons(int id, String name, String description, String icon,int discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.discount = discount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

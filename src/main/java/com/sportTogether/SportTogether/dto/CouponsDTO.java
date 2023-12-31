package com.sportTogether.SportTogether.dto;

import javax.persistence.Column;

public class CouponsDTO {
    public int id ;


    public String name ;

    public String description ;


    public int discount ;

    public CouponsDTO() {
    }

    public CouponsDTO(int id, String name, String description, int discount) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

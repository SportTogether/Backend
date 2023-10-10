package com.sportTogether.SportTogether.dto;

import com.sportTogether.SportTogether.entity.Stars;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class YardsDTO {
    private int id ;

    private String name ;

    private String address;

    private String description ;

    private int price ;

    private double distance ;

    private int  stars ;

    private String type ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public YardsDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public YardsDTO(int id , String name, String address, String description, int price, double distance, int stars, String type ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.price = price;
        this.distance = distance;
        this.stars = stars;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}

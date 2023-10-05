package com.sportTogether.SportTogether.dto;

public class OrdersDTO {
    private String name ;
    private String email;

    private String number ;
    private String yardName ;
    private String startDate ;

    private String status ;

    public OrdersDTO() {
    }

    public OrdersDTO(String name, String email, String number, String yardName, String startDate, String status) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.yardName = yardName;
        this.startDate = startDate;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYardName() {
        return yardName;
    }

    public void setYardName(String yardName) {
        this.yardName = yardName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

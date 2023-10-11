package com.sportTogether.SportTogether.dto;

public class OrdersDTO {
    private int id ;
    private String name ;
    private String email;

    private String number ;
    private String yardName ;
    private String startDate ;

    private int  status ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrdersDTO() {
    }

    public OrdersDTO(int id , String name, String email, String number, String yardName, String startDate, int  status) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int  status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

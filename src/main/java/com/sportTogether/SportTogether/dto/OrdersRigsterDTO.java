package com.sportTogether.SportTogether.dto;

public class OrdersRigsterDTO {
    private int users_id ;
    private int yards_id ;
    private int status_id ;
    private String start_date;
    private String end_date ;

    public OrdersRigsterDTO(int users_id, int yards_id, int status_id, String start_date, String end_date) {
        this.users_id = users_id;
        this.yards_id = yards_id;
        this.status_id = status_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getYards_id() {
        return yards_id;
    }

    public void setYards_id(int yards_id) {
        this.yards_id = yards_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}

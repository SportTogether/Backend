package com.sportTogether.SportTogether.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users ;
    @ManyToOne
    @JoinColumn(name = "yards_id")
    private Yards yards;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @Column(name ="start_time")
    private String startTime ;
    @Column(name ="end_time")
    private String endTime ;

    public Orders() {
    }

    public Orders( Users users, Yards yards, Status status, String startTime, String endTime) {

        this.users = users;
        this.yards = yards;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Yards getYards() {
        return yards;
    }

    public void setYards(Yards yards) {
        this.yards = yards;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

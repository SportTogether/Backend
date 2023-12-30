package com.sportTogether.SportTogether.entity;

import javax.persistence.*;

@Entity(name= "users_matches")
public class Users_Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;


    @ManyToOne
    @JoinColumn(name = "users_id")
    public Users users;

    @ManyToOne
    @JoinColumn(name = "matches_id")
    public Matches matches;

    public Users_Matches() {
    }

    public Users_Matches(int id, Users users, Matches matches) {
        this.id = id;
        this.users = users;
        this.matches = matches;
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

    public Matches getMatches() {
        return matches;
    }

    public void setMatches(Matches matches) {
        this.matches = matches;
    }
}

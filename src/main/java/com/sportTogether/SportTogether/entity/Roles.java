package com.sportTogether.SportTogether.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id ;

    @Column
    private String name ;

    @OneToMany(mappedBy = "roles")
    private Set<Users> listUsers;

    public Roles() {
    }

    public Roles(int id , String name) {
        this.name = name;
        this.id=id ;
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
}

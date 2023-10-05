package com.sportTogether.SportTogether.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "stars")
public class Stars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private int quantities ;

    @OneToMany(mappedBy = "stars")
    private Set<Yards> listYards;

    public Set<Yards> getListYards() {
        return listYards;
    }

    public void setListYards(Set<Yards> listYards) {
        this.listYards = listYards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }
}

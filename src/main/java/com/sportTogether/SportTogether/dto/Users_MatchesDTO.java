package com.sportTogether.SportTogether.dto;

public class Users_MatchesDTO {
    private int id ;
    private int users_id ;
    private int matches_id ;

    public Users_MatchesDTO() {
    }

    public Users_MatchesDTO(int id, int users_id, int matches_id) {
        this.id = id;
        this.users_id = users_id;
        this.matches_id = matches_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getMatches_id() {
        return matches_id;
    }

    public void setMatches_id(int matches_id) {
        this.matches_id = matches_id;
    }
}

package com.sportTogether.SportTogether.dto;

public class UpdateOrdersDTO {
    private int users_id ;
    private int status_id;

    public UpdateOrdersDTO(int users_id, int status_id) {
        this.users_id = users_id;
        this.status_id = status_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int orders_id) {
        this.status_id = orders_id;
    }
}

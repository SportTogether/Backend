package com.sportTogether.SportTogether.dto;



public class MatchesDTO {
    private int id ;

    private String name    ;

    private String time ;

    private String address ;

    private int  current_quantities ;

    private int  max_quantities ;
    private String icon ;

    public MatchesDTO() {
    }

    public MatchesDTO(int idd, String name, String time, String address, int current_quantities, int max_quantities, String icon) {
        this.id = idd;
        this.name = name;
        this.time = time;
        this.address = address;
        this.current_quantities = current_quantities;
        this.max_quantities = max_quantities;
        this.icon = icon;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCurrent_quantities() {
        return current_quantities;
    }

    public void setCurrent_quantities(int current_quantities) {
        this.current_quantities = current_quantities;
    }

    public int getMax_quantities() {
        return max_quantities;
    }

    public void setMax_quantities(int max_quantities) {
        this.max_quantities = max_quantities;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

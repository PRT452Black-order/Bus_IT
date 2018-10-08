package com.example.cdu_nb.bus_it;

public class Ticket {
    public String route;
    public String date;
    public String fare;

    public Ticket(String route,String fare, String date) {
        this.route = route;
        this.fare= fare;
        this.date = date;
    }
}



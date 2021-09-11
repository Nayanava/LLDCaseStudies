package com.system.design.lld.movieticketbooking.models;
/**
 * @author nayanava
 */

import java.util.List;

public class SeatingArrangement {
    private int totalSeats;
    private List<Seat> seats;

    public SeatingArrangement(int totalSeats, List<Seat> seats) {
        this.totalSeats = totalSeats;
        this.seats = seats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}

package com.system.design.lld.movieticketbooking.requests;
/**
 * @author nayanava
 */

import com.system.design.lld.movieticketbooking.models.Seat;

import java.util.List;

public class BookingRequest {
    private String userId;
    private String showId;
    private List<Seat> seats;

    public BookingRequest(String userId, String showId, List<Seat> seats) {
        this.userId = userId;
        this.showId = showId;
        this.seats = seats;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}

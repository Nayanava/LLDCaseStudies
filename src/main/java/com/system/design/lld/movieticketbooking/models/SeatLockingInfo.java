package com.system.design.lld.movieticketbooking.models;
/**
 * @author nayanava
 */

import java.util.Date;

public class SeatLockingInfo {
    private Seat seat;
    private String showId;
    private Date timeOfLock;
    private long timeToLive;
    public SeatLockingInfo(Seat seat, String showId, Date timeOfLock, long timeToLive) {
        this.seat = seat;
        this.showId = showId;
        this.timeOfLock = timeOfLock;
        this.timeToLive = timeToLive;
    }

    public Seat getSeat() {
        return seat;
    }

    public String getShowId() {
        return showId;
    }

    public Date getTimeOfLock() {
        return timeOfLock;
    }

    public long getTimeToLive() {
        return timeToLive;
    }
}

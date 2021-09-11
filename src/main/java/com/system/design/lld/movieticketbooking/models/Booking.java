package com.system.design.lld.movieticketbooking.models;
/**
 * @author nayanava
 */

import com.system.design.lld.common.IdGenerator;

import java.util.List;

public class Booking {
    private String bookingId;
    private Show show;
    private List<Seat> bookedSeats;
    private String user;
    private BookingStatus bookingStatus;

    public Booking( Show show, List<Seat> bookedSeats, String user, BookingStatus bookingStatus) {
        this.bookingId = IdGenerator.generate("BID");
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.user = user;
        this.bookingStatus = bookingStatus;
    }
}

package com.system.design.lld.movieticketbooking.models;

import com.system.design.lld.common.IdGenerator;
import com.system.design.lld.movieticketbooking.service.PaymentService;

import java.util.Objects;

/**
 * @author nayanava
 */

public class Seat {
    private String seatId;
    private int rowNumber;
    private int seatNumber;
    private SeatState seatState;
    public Seat() {
        this.seatId = IdGenerator.generate("STIT");
    }
    public Seat( int rowNumber, int seatNumber, SeatState seatState) {
        this();
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.seatState = seatState;
    }

    public String getSeatId() {
        return seatId;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatState getSeatState() {
        return seatState;
    }

    public void setSeatState(SeatState seatState) {
        this.seatState = seatState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return rowNumber == seat.rowNumber && seatNumber == seat.seatNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowNumber, seatNumber);
    }
}

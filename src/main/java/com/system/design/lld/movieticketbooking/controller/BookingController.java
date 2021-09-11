package com.system.design.lld.movieticketbooking.controller;
/**
 * @author nayanava
 */

import com.system.design.lld.movieticketbooking.models.Booking;
import com.system.design.lld.movieticketbooking.requests.BookingRequest;
import com.system.design.lld.movieticketbooking.service.BookingService;

import java.io.InvalidObjectException;

public class BookingController {

    private BookingService bookingService;
    public Booking createBooking(BookingRequest bookingRequest) throws InvalidObjectException {
        return bookingService.createBooking(bookingRequest);
    }
}

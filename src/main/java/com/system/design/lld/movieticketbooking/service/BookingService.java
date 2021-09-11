package com.system.design.lld.movieticketbooking.service;
/**
 * @author nayanava
 */

import com.system.design.lld.movieticketbooking.exceptions.SeatUnavailableException;
import com.system.design.lld.movieticketbooking.models.Booking;
import com.system.design.lld.movieticketbooking.models.BookingStatus;
import com.system.design.lld.movieticketbooking.models.Show;
import com.system.design.lld.movieticketbooking.models.builder.BookingBuilder;
import com.system.design.lld.movieticketbooking.providers.SeatsLockProvider;
import com.system.design.lld.movieticketbooking.repository.IBookingRepository;
import com.system.design.lld.movieticketbooking.requests.BookingRequest;

import java.io.InvalidObjectException;

public class BookingService {

    private SeatAvailabilityService seatAvailabilityService;
    private ShowService showService;
    private IBookingRepository bookingRepository;
    private SeatsLockProvider seatsLockProvider;
    public Booking createBooking(final BookingRequest bookingRequest) throws InvalidObjectException {
        //1. check seat availability
        //2. temporarily block the seats
        //if seats are already blocked - throw error
        //else block the seats
        Show show = showService.getShowDetails(bookingRequest.getShowId());
        if(!showService.seatsAvailable(bookingRequest.getUserId(), show, bookingRequest.getSeats())) {
            throw new SeatUnavailableException();
        }
        boolean seatsLocked = seatsLockProvider.lockSeats(bookingRequest.getUserId(),
                show,
                bookingRequest.getSeats());
        if(!seatsLocked) {
            throw new SeatUnavailableException();
        }
        Booking booking = new BookingBuilder()
                .setBookingStatus(BookingStatus.IN_PROGRESS)
                .setBookedSeats(bookingRequest.getSeats())
                .setShow(show)
                .setUser(bookingRequest.getUserId())
                .build();
        bookingRepository.save(booking);
        return booking;
    }
}

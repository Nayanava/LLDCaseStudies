package com.system.design.lld.movieticketbooking.models.builder;

import com.system.design.lld.movieticketbooking.models.Booking;
import com.system.design.lld.movieticketbooking.models.BookingStatus;
import com.system.design.lld.movieticketbooking.models.Seat;
import com.system.design.lld.movieticketbooking.models.Show;

import java.util.List;

public class BookingBuilder {
        private Show show;
        private List<Seat> bookedSeats;
        private String user;
        private BookingStatus bookingStatus;

        public BookingBuilder() {

        }

        public BookingBuilder setShow(Show show) {
            this.show = show;
            return this;
        }

        public BookingBuilder setBookedSeats(List<Seat> bookedSeats) {
            this.bookedSeats = bookedSeats;
            return this;
        }

        public BookingBuilder setUser(String user) {
            this.user = user;
            return this;
        }

        public BookingStatus getBookingStatus() {
            return bookingStatus;
        }

        public BookingBuilder setBookingStatus(BookingStatus bookingStatus) {
            this.bookingStatus = bookingStatus;
            return this;
        }

        public Booking build() {
            return new Booking(show, bookedSeats, user, bookingStatus);
        }
    }
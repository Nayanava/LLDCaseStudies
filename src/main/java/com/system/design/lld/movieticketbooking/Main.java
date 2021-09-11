package com.system.design.lld.movieticketbooking;
/**
 * @author nayanava
 */

import com.system.design.lld.common.IdGenerator;
import com.system.design.lld.movieticketbooking.controller.BookingController;
import com.system.design.lld.movieticketbooking.controller.PaymentController;
import com.system.design.lld.movieticketbooking.models.Seat;
import com.system.design.lld.movieticketbooking.models.Show;
import com.system.design.lld.movieticketbooking.requests.BookingRequest;
import com.system.design.lld.movieticketbooking.service.ShowService;

import java.io.*;
import java.util.List;

public class Main {

    private static BookingController bookingController;
    private static PaymentController paymentController;

    public Main(BookingController bookingController,
                PaymentController paymentController) {
        Main.bookingController = bookingController;
        Main.paymentController = paymentController;
    }

    public static void main(String[] args) throws InvalidObjectException{

        System.out.println(bookingController.
                createBooking(new BookingRequest(IdGenerator.generate("UID"),
                        new Show().getShowId(), List.of(new Seat()))) );
    }
}

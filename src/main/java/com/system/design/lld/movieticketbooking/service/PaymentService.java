package com.system.design.lld.movieticketbooking.service;
/**
 * @author nayanava
 */

public class PaymentService {
    BookingService bookingService;

    public boolean onPaymentSuccess(String bookingId) {
        //bookingService.blockSeatsPermanently();
        return true;
    }

    public boolean onPaymentProcessingFailure(String bookingId) {
        //1. it will free the locks if any on the seats
        //2. mark the state of the booking as FAILED
        return false;
    }
}

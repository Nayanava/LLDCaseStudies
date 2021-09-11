package com.system.design.lld.movieticketbooking.controller;

import com.system.design.lld.movieticketbooking.service.PaymentService;

/**
 * @author nayanava
 */

public class PaymentController {
    PaymentService paymentService;

    public void confirmBooking(String bookingId) {
        paymentService.onPaymentSuccess(bookingId);
    }

    public void processPaymentFailed(String bookingId) {
        paymentService.onPaymentProcessingFailure(bookingId);
    }
}

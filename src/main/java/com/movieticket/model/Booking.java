
package com.movieticket.model;

import java.io.Serializable;

public class Booking implements Serializable {

    private String bookingId;
    private Movie movie;
    private String customerName;
    private String email;
    private String showTime;
    private int tickets;
    private double totalAmount;
    private String paymentMethod;
    private boolean paid;

    public Booking(String bookingId, Movie movie,
                   String customerName, String email,
                   String showTime, int tickets) {

        this.bookingId = bookingId;
        this.movie = movie;
        this.customerName = customerName;
        this.email = email;
        this.showTime = showTime;
        this.tickets = tickets;
        this.totalAmount = movie.getPrice() * tickets;
        this.paid = false;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getShowTime() {
        return showTime;
    }

    public int getTickets() {
        return tickets;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isPaid() {
        return paid;
    }

    public void completePayment(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.paid = true;
    }
}

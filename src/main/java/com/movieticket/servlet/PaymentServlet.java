
package com.movieticket.servlet;

import com.movieticket.model.Booking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        Booking booking = (Booking) session.getAttribute("currentBooking");

        if (booking == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        if (booking.isPaid()) {
            response.sendRedirect(request.getContextPath() + "/confirmation");
            return;
        }

        request.setAttribute("booking", booking);

        request.getRequestDispatcher("/WEB-INF/views/payment.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        Booking booking = (Booking) session.getAttribute("currentBooking");

        if (booking == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        if (!booking.isPaid()) {

            String paymentMethod = request.getParameter("paymentMethod");

            if (paymentMethod == null ||
                    !paymentMethod.matches("UPI|CARD|CASH")) {

                response.sendError(
                        HttpServletResponse.SC_BAD_REQUEST,
                        "Please select a valid payment method."
                );
                return;
            }

            booking.completePayment(paymentMethod);

            @SuppressWarnings("unchecked")
            List<Booking> bookings =
                    (List<Booking>) session.getAttribute("myBookings");

            if (bookings == null) {
                bookings = new ArrayList<>();
                session.setAttribute("myBookings", bookings);
            }

            bookings.add(booking);
        }

        response.sendRedirect(
                request.getContextPath() + "/confirmation"
        );
    }
}

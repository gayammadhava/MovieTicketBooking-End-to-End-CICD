
package com.movieticket.servlet;

import com.movieticket.model.Booking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {

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

        if (booking == null || !booking.isPaid()) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        request.setAttribute("booking", booking);

        request.getRequestDispatcher("/WEB-INF/views/confirmation.jsp")
                .forward(request, response);
    }
}


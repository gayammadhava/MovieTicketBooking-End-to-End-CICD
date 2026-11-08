
package com.movieticket.servlet;

import com.movieticket.model.Booking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/my-bookings")
public class MyBookingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            request.setAttribute("bookings", Collections.emptyList());
        } else {
            @SuppressWarnings("unchecked")
            List<Booking> bookings =
                    (List<Booking>) session.getAttribute("myBookings");

            request.setAttribute(
                    "bookings",
                    bookings == null ? Collections.emptyList() : bookings
            );
        }

        request.getRequestDispatcher("/WEB-INF/views/my-bookings.jsp")
                .forward(request, response);
    }
}

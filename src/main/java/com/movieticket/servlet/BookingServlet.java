
package com.movieticket.servlet;

import com.movieticket.data.MovieCatalog;
import com.movieticket.model.Booking;
import com.movieticket.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/book")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            int movieId = Integer.parseInt(request.getParameter("movieId"));
            int tickets = Integer.parseInt(request.getParameter("tickets"));

            String name = request.getParameter("customerName");
            String email = request.getParameter("email");
            String showTime = request.getParameter("showTime");

            if (name == null || name.trim().isEmpty()
                    || name.trim().length() > 100
                    || email == null
                    || !email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
                    || showTime == null
                    || !showTime.matches(
                    "10:00 AM|01:30 PM|04:45 PM|08:15 PM")
                    || tickets < 1 || tickets > 10) {

                response.sendError(
                        HttpServletResponse.SC_BAD_REQUEST,
                        "Invalid booking details."
                );
                return;
            }

            Movie movie = MovieCatalog.getMovieById(movieId);

            if (movie == null) {
                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND,
                        "Movie not found."
                );
                return;
            }

            String bookingId = "MTB-" +
                    UUID.randomUUID().toString()
                    .substring(0, 8).toUpperCase();

            Booking booking = new Booking(
                    bookingId,
                    movie,
                    name.trim(),
                    email.trim(),
                    showTime,
                    tickets
            );

            HttpSession session = request.getSession();
            session.setAttribute("currentBooking", booking);

            response.sendRedirect(
                    request.getContextPath() + "/payment"
            );

        } catch (NumberFormatException e) {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid movie or ticket number."
            );
        }
    }
}

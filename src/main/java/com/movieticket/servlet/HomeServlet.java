
package com.movieticket.servlet;

import com.movieticket.data.MovieCatalog;
import com.movieticket.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = {"", "/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String search = request.getParameter("search");
        List<Movie> movies = MovieCatalog.getAllMovies();

        if (search != null && !search.trim().isEmpty()) {
            String keyword = search.trim().toLowerCase();

            movies = movies.stream()
                    .filter(movie ->
                            movie.getTitle().toLowerCase().contains(keyword)
                            || movie.getGenre().toLowerCase().contains(keyword)
                            || movie.getLanguage().toLowerCase().contains(keyword))
                    .collect(Collectors.toList());
        }

        request.setAttribute("movies", movies);
        request.setAttribute("search", search == null ? "" : search);

        request.getRequestDispatcher("/WEB-INF/views/home.jsp")
                .forward(request, response);
    }
}

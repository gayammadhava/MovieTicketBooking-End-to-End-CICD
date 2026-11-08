
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>ShowTime - Movie Tickets</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>

<header class="navbar">
    <a class="logo" href="${pageContext.request.contextPath}/">
        SHOWTIME
    </a>

    <nav>
        <a href="${pageContext.request.contextPath}/">Movies</a>
        <a href="${pageContext.request.contextPath}/my-bookings">
            My Bookings
        </a>
    </nav>
</header>

<section class="hero">
    <h1>Book Your Movie Tickets</h1>
    <p>Experience your favourite movies on the big screen.</p>

    <form action="${pageContext.request.contextPath}/home"
          method="get" class="search-form">

        <input type="text"
               name="search"
               placeholder="Search movies, genre or language"
               value="<c:out value='${search}'/>">

        <button type="submit">Search</button>
    </form>
</section>

<main class="container">

    <h2>Available Movies</h2>

    <c:if test="${empty movies}">
        <p>No movies found. Try another search.</p>
    </c:if>

    <div class="movie-grid">

        <c:forEach var="movie" items="${movies}">

            <div class="movie-card">

                <img src="${pageContext.request.contextPath}${movie.imageUrl}"
                     alt="<c:out value='${movie.title}'/>">

                <div class="movie-info">

                    <h3><c:out value="${movie.title}"/></h3>

                    <p>
                        <c:out value="${movie.genre}"/> |
                        <c:out value="${movie.language}"/>
                    </p>

                    <h4>₹<c:out value="${movie.price}"/> / ticket</h4>

                    <form action="${pageContext.request.contextPath}/book"
                          method="post">

                        <input type="hidden"
                               name="movieId"
                               value="${movie.id}">

                        <label>Customer Name</label>
                        <input type="text"
                               name="customerName"
                               maxlength="100"
                               required>

                        <label>Email</label>
                        <input type="email"
                               name="email"
                               required>

                        <label>Show Time</label>
                        <select name="showTime" required>
                            <option value="10:00 AM">10:00 AM</option>
                            <option value="01:30 PM">01:30 PM</option>
                            <option value="04:45 PM">04:45 PM</option>
                            <option value="08:15 PM">08:15 PM</option>
                        </select>

                        <label>Tickets</label>
                        <input type="number"
                               name="tickets"
                               min="1"
                               max="10"
                               value="1"
                               required>

                        <button type="submit" class="book-btn">
                            Book Tickets
                        </button>

                    </form>
                </div>
            </div>

        </c:forEach>

    </div>

</main>

<footer>
    <p>© 2026 ShowTime Movie Ticket Booking</p>
    <p>Demo project - No real payments accepted.</p>
</footer>

<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

</body>
</html>

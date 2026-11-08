
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>My Bookings - ShowTime</title>
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
    </nav>
</header>

<main class="container">

    <h1>My Bookings</h1>

    <c:choose>

        <c:when test="${empty bookings}">
            <div class="summary">
                <h3>No bookings found.</h3>
                <p>Book a movie to see your booking history here.</p>

                <a class="book-btn button-link"
                   href="${pageContext.request.contextPath}/">
                    Browse Movies
                </a>
            </div>
        </c:when>

        <c:otherwise>

            <div class="booking-list">

                <c:forEach var="booking" items="${bookings}">

                    <div class="summary">

                        <h3>
                            <c:out value="${booking.movie.title}"/>
                        </h3>

                        <p>Booking ID:
                            <c:out value="${booking.bookingId}"/>
                        </p>

                        <p>Show Time:
                            <c:out value="${booking.showTime}"/>
                        </p>

                        <p>Tickets:
                            <c:out value="${booking.tickets}"/>
                        </p>

                        <p>Total:
                            ₹<c:out value="${booking.totalAmount}"/>
                        </p>

                        <p>Payment:
                            <c:out value="${booking.paymentMethod}"/>
                        </p>

                        <p class="paid">Payment Completed</p>

                    </div>

                </c:forEach>

            </div>

        </c:otherwise>

    </c:choose>

</main>

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmed - ShowTime</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>

<header class="navbar">
    <a class="logo" href="${pageContext.request.contextPath}/">
        SHOWTIME
    </a>
</header>

<div class="form-container confirmation">

    <div class="success-icon">✓</div>

    <h1>Booking Confirmed!</h1>

    <p>Your demo booking has been completed successfully.</p>

    <div class="summary">

        <h3>Booking Details</h3>

        <p>Booking ID:
            <strong><c:out value="${booking.bookingId}"/></strong>
        </p>

        <p>Movie:
            <c:out value="${booking.movie.title}"/>
        </p>

        <p>Customer:
            <c:out value="${booking.customerName}"/>
        </p>

        <p>Email:
            <c:out value="${booking.email}"/>
        </p>

        <p>Show Time:
            <c:out value="${booking.showTime}"/>
        </p>

        <p>Tickets:
            <c:out value="${booking.tickets}"/>
        </p>

        <p>Payment Method:
            <c:out value="${booking.paymentMethod}"/>
        </p>

        <h2>Total Paid: ₹<c:out value="${booking.totalAmount}"/></h2>

    </div>

    <a class="book-btn button-link"
       href="${pageContext.request.contextPath}/my-bookings">
        View My Bookings
    </a>

    <a class="secondary-link"
       href="${pageContext.request.contextPath}/">
        Book Another Movie
    </a>

</div>

</body>
</html>

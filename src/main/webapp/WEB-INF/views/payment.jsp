
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Demo Payment - ShowTime</title>
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

<div class="form-container">

    <h1>Complete Your Booking</h1>

    <div class="summary">
        <h3><c:out value="${booking.movie.title}"/></h3>

        <p>Customer:
            <c:out value="${booking.customerName}"/>
        </p>

        <p>Show Time:
            <c:out value="${booking.showTime}"/>
        </p>

        <p>Tickets:
            <c:out value="${booking.tickets}"/>
        </p>

        <h2>Total: ₹<c:out value="${booking.totalAmount}"/></h2>
    </div>

    <form action="${pageContext.request.contextPath}/payment"
          method="post">

        <h3>Select Demo Payment Method</h3>

        <label class="payment-option">
            <input type="radio" name="paymentMethod"
                   value="UPI" required>
            UPI
        </label>

        <label class="payment-option">
            <input type="radio" name="paymentMethod"
                   value="CARD">
            Debit / Credit Card
        </label>

        <label class="payment-option">
            <input type="radio" name="paymentMethod"
                   value="CASH">
            Cash at Counter
        </label>

        <p class="notice">
            This is a demonstration only. No actual money will be charged.
        </p>

        <button type="submit" class="book-btn">
            Confirm Demo Payment
        </button>
    </form>

    <a href="${pageContext.request.contextPath}/">
        Back to Movies
    </a>

</div>

</body>
</html>

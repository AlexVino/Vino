<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="utf-8">

    <title><spring:message code="main.title"/></title>
    <meta name="description" content="">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <meta property="og:image" content="path/to/image.jpg">
    <link rel="shortcut icon" href="/img/favicon/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="/img/favicon/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/img/favicon/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/img/favicon/apple-touch-icon-114x114.png">

    <!-- Chrome, Firefox OS and Opera -->
    <meta name="theme-color" content="#000">
    <!-- Windows Phone -->
    <meta name="msapplication-navbutton-color" content="#000">
    <!-- iOS Safari -->
    <meta name="apple-mobile-web-app-status-bar-style" content="#000">

    <link rel="stylesheet" href="/css/main.car.min.css">
    <link rel="stylesheet" href="/css/error_block.css">

</head>

<body class="ishome">

<c:import url="header.jsp"/>

<div id="my-content">

    <div class="container">

        <div class="row justify-content-between">

            <div class="col-5">
                <h1 class="vehicle__title">${car.fullModel}</h1>
            </div>

            <div class="col">
                <p class="vehicle__title">$${car.price}</p>
            </div>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <div class="col">
                    <button id="btn-edit" class="button"><spring:message code="cars.edit"/></button>
                </div>
                <div class="col">
                    <button id="btn-delete" class="button"><spring:message code="cars.delete"/></button>
                </div>
            </security:authorize>

            <security:authorize access="hasRole('ROLE_USER') or isAnonymous()">
            <div class="col">
                <button id="btn-order" class="button"><spring:message code="orders.order"/></button>
            </div>
            </security:authorize>

        </div>

        <div class="row">

            <div class="col-5">
                <img src="${car.image}" class="main-image">
            </div>

            <div class="col">

                <div class="row">
                    <section class="vehicle-desc">
                        <h3 class="vehicle-desc__title"><spring:message code="cars.description"/></h3>
                        <div id="vehicle-desc_desc-wrap" class=" overflows">
                            <p class="vehicle-desc__text" id="vehicle-desc_description">${car.description}</p>
                        </div>
                    </section>
                </div>
                <div class="row">
                    <section class="spec">

                        <ul class="spec__icons">

                            <li>
                                <i class="icon--engine"></i>
                                <span class="spec__caption">${car.engine} <spring:message code="cars.litre"/></span>
                            </li>

                            <li>
                                <div class="mileage">${car.mileage}</div>
                                <span class="spec__caption"><spring:message code="cars.mileage"/></span>
                            </li>

                            <li><i class="icon--fuel"></i><span class="spec__caption">${car.fuelTypeLocal}</span></li>

                            <li><i class="icon--calendar-blank reg__month" data-reg-month="${car.year}"></i>
                                <span class="spec__caption reg__year"><spring:message code="cars.year"/></span></li>

                            <li class="spec-item--bodystyle"><i class="icon--${car.bodystyle}"></i>
                                <span class="spec__caption">${car.bodystyleLocal}</span></li>

                            <li><i class="icon--gears"></i><span class="spec__caption">${car.transmissionLocal}</span></li>
                        </ul>
                    </section>
                </div>

            </div>
        </div>

    </div>

</div>

<div id="main-footer">
    <div class="container-fluid">
        <div class="row justify-content-around">

            <div class="col-auto">
                <a href="/" class="logo"><img src="/img/MyGarageLogo.svg" alt="MyGarage"></a>
            </div>
            <div class="col-auto">
                <div class="phone"><i class="fa fa-mobile"></i>+375 29 666-11-83</div>
            </div>

        </div>
    </div>
</div>

<div class="error_message">
    <p>Error</p>
</div>

<input type="hidden" id="cancel" value="<spring:message code="main.cancel"/>">
<input type="hidden" id="order" value="<spring:message code="orders.order"/>">
<input type="hidden" id="carId" value="${car.carId}">

<script src="/js/scripts.min.js"></script>
<script src="/js/car.js"></script>
<script src="/js/error.js"></script>

</body>
</html>
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

                <div class="row">
                    <div class="col">
                        <h1 class="vehicle__title">${car.fullModel}</h1>
                    </div>
                </div>

                <div class="row justify-content-between">
                    <security:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_DEALER')">
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
            </div>

            <div class="col-4">
                <div class="row">
                    <div class="col">

                        <dl class="car-card__price-option">
                            <dt><span><spring:message code="main.price"/></span></dt>
                            <dd>$ ${car.price}</dd>
                        </dl>

                        <div id='appendprice'>

                        </div>

                    </div>
                </div>

            </div>

        </div>

        <div class="row">

            <div class="col-5">
                <img src="${car.image}" class="main-image">
            </div>

            <div class="col-7">

                <div class="row">
                    <div class="col">
                        <section class="vehicle-desc">
                            <h3 class="vehicle-desc__title"><spring:message code="cars.description"/></h3>
                            <div id="vehicle-desc_desc-wrap" class=" overflows">
                                <p class="vehicle-desc__text" id="vehicle-desc_description">${car.description}</p>
                            </div>
                        </section>
                    </div>
                </div>
                <div class="row">
                    <div class="col" style="padding-right: 0px">
                        <section class="spec">

                            <ul class="spec__icons">

                                <li>
                                    <i class="icon--engine"></i>
                                    <span class="spec__caption">${car.enginevolume} <spring:message
                                            code="cars.millilitre"/></span>
                                </li>

                                <li>
                                    <div class="mileage">${car.mileage}</div>
                                    <span class="spec__caption"><spring:message code="cars.mileage"/></span>
                                </li>

                                <li><i class="icon--fuel"></i><span class="spec__caption">${car.fuelTypeLocal}</span>
                                </li>

                                <li><i class="icon--calendar-blank reg__month" data-reg-month="${car.year}"></i>
                                    <span class="spec__caption reg__year"><spring:message code="cars.year"/></span></li>

                                <li class="spec-item--bodystyle"><i class="icon--${car.bodystyle}"></i>
                                    <span class="spec__caption">${car.bodystyleLocal}</span></li>

                                <li><i class="icon--gears"></i><span
                                        class="spec__caption">${car.transmissionLocal}</span>
                                </li>

                                <li>
                                    <div title="${car.color}" class="m-multi__item _${car.color}"></div>
                                    <span class="spec__caption"><spring:message code="search.color"/></span>
                                </li>
                            </ul>

                        </section>
                    </div>
                </div>

            </div>
        </div>

        <div class="row justify-content-between">

            <div class="col-6">

                <div class="car-card__al-item-title">
                    <spring:message code="cars.characteristics"/>
                </div>

                <div class="row">
                    <div class="col">
                        <div id='characteristics1'>

                        </div>
                    </div>
                    <div class="col">
                        <div id='characteristics2'>

                        </div>
                    </div>
                </div>
            </div>

            <div class="col-5">

                <div class="car-card__al-item-title">
                    <spring:message code="search.visibility"/>
                </div>

                <div id='visibility'>

                </div>

                <div class="car-card__al-item-title">
                    <spring:message code="search.multimedia"/>
                </div>

                <div id='multimedia'>

                </div>

                <div class="car-card__al-item-title">
                    <spring:message code="search.comfort"/>
                </div>

                <div id='comfort'>

                </div>
            </div>

        </div>

    </div>

</div>

<div>
    <h1 style="color: transparent; height: 100px">


    </h1>
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

<input type="hidden" id="rrPrice" value="<spring:message code="main.rrPrice"/>">
<input type="hidden" id="discount" value="<spring:message code="main.discount"/>">
<input type="hidden" id="cancel" value="<spring:message code="main.cancel"/>">
<input type="hidden" id="order" value="<spring:message code="orders.order"/>">
<input type="hidden" id="adId" value="${car.adId}">
<input type="hidden" id="carId" value="${car.carId}">

<input type="hidden" id="headlights" value="<spring:message code="search.headlights.any"/>">
<input type="hidden" id="drivetype" value="<spring:message code="search.drivetype.any"/>">
<input type="hidden" id="complectation" value="<spring:message code="cars.complectation"/>">
<input type="hidden" id="vin" value="<spring:message code="cars.vin"/>">
<input type="hidden" id="horsepower" value="<spring:message code="cars.horsepower"/>">
<input type="hidden" id="maxspeed" value="<spring:message code="cars.maxspeed"/>">
<input type="hidden" id="commonconsumption" value="<spring:message code="cars.commonconsumption"/>">
<input type="hidden" id="cityconsumption" value="<spring:message code="cars.cityconsumption"/>">
<input type="hidden" id="routeconsumption" value="<spring:message code="cars.routeconsumption"/>">
<input type="hidden" id="acceleration" value="<spring:message code="cars.acceleration"/>">
<input type="hidden" id="length" value="<spring:message code="cars.length"/>">
<input type="hidden" id="width" value="<spring:message code="cars.width"/>">

<input type="hidden" id="electricheatingofthewindshield"
       value="<spring:message code="search.electricheatingofthewindshield"/>">
<input type="hidden" id="electricheatingofsidemirrors"
       value="<spring:message code="search.electricheatingofsidemirrors"/>">
<input type="hidden" id="headlightwashersystem" value="<spring:message code="search.headlightwashersystem"/>">
<input type="hidden" id="rainsensor" value="<spring:message code="search.rainsensor"/>">
<input type="hidden" id="foglight" value="<spring:message code="search.foglight"/>">

<input type="hidden" id="bluetooth" value="<spring:message code="search.bluetooth"/>">
<input type="hidden" id="usb" value="<spring:message code="search.usb"/>">
<input type="hidden" id="aux" value="<spring:message code="search.aux"/>">
<input type="hidden" id="navigationsystem" value="<spring:message code="search.navigationsystem"/>">

<input type="hidden" id="cruisecontrol" value="<spring:message code="search.cruisecontrol"/>">
<input type="hidden" id="parktronic" value="<spring:message code="search.parktronic"/>">
<input type="hidden" id="climatecontrol" value="<spring:message code="search.climatecontrol"/>">
<input type="hidden" id="powerWindows" value="<spring:message code="search.powerWindows"/>">
<input type="hidden" id="steeringadjustment" value="<spring:message code="search.steeringadjustment"/>">

<input type="hidden" id="confirmdeleting" value="<spring:message code="cars.confirmdeleting"/>">

<script src="/js/scripts.min.js"></script>
<script src="/js/car.js"></script>
<script src="/js/error.js"></script>

</body>
</html>
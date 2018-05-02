<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="utf-8">

    <title>MAKET</title>
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

    <link rel="stylesheet" href="/css/car.min.css">
    <link rel="stylesheet" href="/css/car.one.min.css">

</head>

<body class="ishome">

<header class="site-header registration">
    <div class="top-line boxShadow">
        <div class="container-fluid">
            <div class="row justify-content-between">
                <div class="col-auto"><a href="/" class="logo"><img src="/img/MyGarageLogo.svg" alt="MyGarage"></a></div>

                <div class="col-6"></div>

                <!-- LANGUAGE BUTTON -->
                <div class="col-auto switch-button">
                    <span class="switch-active"></span>
                    <button class="switch-button-case left active-case">RU</button>
                    <button class="switch-button-case right">EN</button>
                </div>


                <div class="col-auto"><a href="#" class="button b-sign">Orders</a></div>
                <div class="col-auto"><a href="#" class="button b-sign">Sign in</a></div>

            </div>
        </div>
    </div>
</header>

<div id="my-content">

    <div class="vehiclecontainer contentcontainer">

        <div class="container-fluid">
            <div class="row">
                <div class="col">

                    <section class="images">
                        <div class="images__main">
                            <a data-audit="1,47365827,63132" data-audittitle="image" href="javascript:void(0)" class="gallery-trigger main-image-wrap">
                                <img src="https://images-ae.azureedge.net/AETA55325/AETV11765902_1.jpg" class="main-image" id="mainImageSrc" alt="2005 (05) - Audi A4 1.8T quattro Cabriolet 2d 1781cc 2-Door, photo 1 of 15" data-imgindex="0" onerror="this.src='https://motors-4.azureedge.net/v3/live/20180315-1138/images/noimage_lrg.jpg'">
                            </a>
                        </div>
                    </section>


                    <section class="vehicle-details">
                        <!-- FLEX UNDER-LEFT -->
                        <section class="spec">

                            <ul class="spec__icons">

                                <li>
                                    <div class="mileage">
                                        <span class="light">${car.mileage}</span><span class="dark">000</span>
                                    </div>
                                    <span class="spec__caption">Mileage</span>
                                </li>

                                <li><i class="icon--fuel"></i><span class="spec__caption">${car.fuelType}</span></li>

                                <li><i class="icon--calendar-blank reg__month" data-reg-month="2005"></i><span class="spec__caption reg__year">${car.year}</span></li>

                                <li class="spec-item--bodystyle"><i class="icon--convertible"></i><span class="spec__caption">${car.bodystyle}</span></li>

                            </ul>
                        </section>

                        <section class="vehicle-desc">
                            <h3 class="vehicle-desc__title">Vehicle description</h3>
                            <div id="vehicle-desc_desc-wrap" class=" overflows">
                                <p class="vehicle-desc__text" id="vehicle-desc_description">Insurance Group 31, Adjustable steering column, Alarm, Anti lock braking system, Central locking, Climate control, Drivers airbag, Electric mirrors, Front Electric windows, Front fog lights, Passenger airbag, Power assisted steering, Radio/CD, Rear Electric windows, Remote Central Locking, Side airbag,This car is in lovely condition and has been really looked after ,viewing essential . GOOGLE OUR PHONE NUMBER !! M A MOTOR COMPANY LTD FINANCE AVAILABLE!! VISIT OUR WEBSITE FOR OVER 80 MORE CARS WWW.MAMOTORCO.CO.UK. WE ALSO STOCK A LARGE SELECTION OF AUTOMATICS ,7 SEATERS AND 4WD's</p>
                            </div>
                        </section>



                        <button class="button ask-question" data-contact="askQuestion" data-dl="ask dealer a question,right side menu">Order</button>

                    </section>
                </div>
            </div>
        </div>
    </div>

</div>

<div id="my-footer">
    <div class="main-footer">
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
</div>

<script src="/js/scripts.min.js"></script>

</body>
</html>
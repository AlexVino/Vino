<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

    <title><spring:message code="main.title"/> </title>
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

    <link rel="stylesheet" href="/css/main.block.min.css">
    <link rel="stylesheet" href="/css/error_block.css">
    <link rel="stylesheet" href="/css/main.min.css">
    <%--<link rel="stylesheet" href="/css/main.min.new.css">--%>

</head>
<body class="ishome">

<div id="my-page">

    <div id="my-header">
        <header class="site-header" style="background-image: url(img/aston-martin.jpg);">
            <div class="top-line boxShadow">
                <div class="container">
                    <div class="row justify-content-between">
                        <div class="col-auto"><a href="/" class="logo"><img src="/img/MyGarageLogo.svg" alt="MyGarage"></a></div>

                        <div class="col-5"></div>

                        <!-- LANGUAGE BUTTON -->
                        <div class="col-auto switch-button">
                            <span class="switch-active"></span>
                            <a href="?lang=ru"><button class="switch-button-case left active-case">RU</button></a>
                            <a href="?lang=en"><button class="switch-button-case right">EN</button></a>
                        </div>

                        <div class="col-auto"><a href="/orders" class="button b-sign"><spring:message code="orders.orders"/></a></div>
                        <div class="col-auto"><a href="/signUp" class="button b-sign"><spring:message code="form.sign_in"/></a></div>
                    </div>
                </div>
            </div>

            <div class="header-flex">
                <div class="flex-center">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-5">
                                <div class="header-composition">
                                    <div class="welcome">
                                        <h1 class="h1"><spring:message code="main.welcome"/></h1>
                                    </div>

                                    <div class="why">
                                        <h2 class="h2"><spring:message code="main.why_h2"/></h2>
                                        <p><spring:message code="main.why_p"/></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    </div>

    <div id="my-content">
        <section class="s-search">
            <div class="make-model">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-3">
                            <p><strong><spring:message code="main.search"/></strong></p>
                        </div>
                    </div>

                    <div class="row justify-content-center no-gutters">
                        <div class="col-sm-3">
                            <div class="subdiv">
                                <dl class="dropy">
                                    <dt class="dropy__title"><span><spring:message code="search.make.any"/></span></dt>
                                    <dd class="dropy__content">
                                        <ul id="filter_makes">
                                            <li><a class="dropy__header"><spring:message code="search.make.any"/></a></li>
                                        </ul>
                                    </dd>
                                    <input type="hidden" name="first">
                                </dl>
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <div class="subdiv">
                                <dl class="dropy">
                                    <dt class="dropy__title"><span><spring:message code="search.model.any"/></span></dt>
                                    <dd class="dropy__content">
                                        <ul id="filter_models">
                                            <li><a class="dropy__header"><spring:message code="search.model.any"/></a></li>
                                        </ul>
                                    </dd>
                                    <input type="hidden" name="first"/>
                                </dl>
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <div class="subdiv">
                                <dl class="dropy">
                                    <dt class="dropy__title"><span><spring:message code="search.min_price.any"/></span></dt>
                                    <dd class="dropy__content">
                                        <ul id="minprice">
                                            <li><a class="dropy__header"><spring:message code="search.min_price.any"/></a></li>
                                            <li><a>$1</a></li>
                                            <li><a>$500</a></li>
                                            <li><a>$1,000</a></li>
                                            <li><a>$2,000</a></li>
                                            <li><a>$3,000</a></li>
                                            <li><a>$4,000</a></li>
                                            <li><a>$5,000</a></li>
                                            <li><a>$6,000</a></li>
                                            <li><a>$7,000</a></li>
                                            <li><a>$8,000</a></li>
                                            <li><a>$9,000</a></li>
                                            <li><a>$10,000</a></li>
                                            <li><a>$12,500</a></li>
                                            <li><a>$15,000</a></li>
                                            <li><a>$17,500</a></li>
                                            <li><a>$20,000</a></li>
                                            <li><a>$25,000</a></li>
                                            <li><a>$30,000</a></li>
                                            <li><a>$35,000</a></li>
                                            <li><a>$40,000</a></li>
                                            <li><a>$45,000</a></li>
                                            <li><a>$50,000</a></li>
                                            <li><a>$55,000</a></li>
                                            <li><a>$60,000</a></li>
                                            <li><a>$75,000</a></li>
                                            <li><a>$100,000</a></li>
                                            <li><a>$250,000</a></li>
                                            <li><a>$500,000</a></li>
                                            <li><a>$1,000,000</a></li>
                                        </ul>
                                    </dd>
                                    <input type="hidden" name="first">
                                </dl>
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <div class="subdiv">
                                <dl class="dropy">
                                    <dt class="dropy__title"><span><spring:message code="search.max_price.any"/></span></dt>
                                    <dd class="dropy__content">
                                        <ul id="maxprice">
                                            <li><a class="dropy__header"><spring:message code="search.max_price.any"/></a></li>
                                            <li><a>$1</a></li>
                                            <li><a>$500</a></li>
                                            <li><a>$1,000</a></li>
                                            <li><a>$2,000</a></li>
                                            <li><a>$3,000</a></li>
                                            <li><a>$4,000</a></li>
                                            <li><a>$5,000</a></li>
                                            <li><a>$6,000</a></li>
                                            <li><a>$7,000</a></li>
                                            <li><a>$8,000</a></li>
                                            <li><a>$9,000</a></li>
                                            <li><a>$10,000</a></li>
                                            <li><a>$12,500</a></li>
                                            <li><a>$15,000</a></li>
                                            <li><a>$17,500</a></li>
                                            <li><a>$20,000</a></li>
                                            <li><a>$25,000</a></li>
                                            <li><a>$30,000</a></li>
                                            <li><a>$35,000</a></li>
                                            <li><a>$40,000</a></li>
                                            <li><a>$45,000</a></li>
                                            <li><a>$50,000</a></li>
                                            <li><a>$55,000</a></li>
                                            <li><a>$60,000</a></li>
                                            <li><a>$75,000</a></li>
                                            <li><a>$100,000</a></li>
                                            <li><a>$250,000</a></li>
                                            <li><a>$500,000</a></li>
                                            <li><a>$1,000,000</a></li>
                                        </ul>
                                    </dd>
                                    <input type="hidden" name="first"/>
                                </dl>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="bodystyles">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-3">
                            <p><strong><spring:message code="search.bodystyle"/></strong></p>
                        </div>
                    </div>

                    <div class="row no-gutters justify-content-center">

                        <div class="col-sm-auto m-multi">
                            <button title="4 x 4" class="m-multi__item _4x4"><span class="label">4 x 4</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="convertible" class="m-multi__item _convertible"><span class="label"><spring:message code="search.bodystyle.convertible"/></span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="coupe" class="m-multi__item _coupe"><span class="label"><spring:message code="search.bodystyle.coupe"/></span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="estate" class="m-multi__item _estate"><span class="label"><spring:message code="search.bodystyle.estate"/></span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="hatchback" class="m-multi__item _hatchback"><span class="label"><spring:message code="search.bodystyle.hatchback"/></span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="people carrier" class="m-multi__item _peoplecarrier"><span class="label"><spring:message code="search.bodystyle.people_carrier"/></span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="pick-up" class="m-multi__item _pickup"><span class="label"><spring:message code="search.bodystyle.pick-up"/></span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="saloon" class="m-multi__item _saloon"><span class="label"><spring:message code="search.bodystyle.saloon"/></span></button>
                        </div>

                    </div>
                </div>

            </div>


            <div class="vehicle-spec">

                <div class="container">

                    <div class="row">
                        <div class="col-sm-3">
                            <p><strong><spring:message code="search.vehicle_spec"/></strong></p>
                        </div>
                    </div>

                    <div class="row justify-content-center">

                        <div class="col-sm-3">
                            <div class="subdiv">
                                <dl class="dropy">
                                    <dt class="dropy__title"><span><spring:message code="search.age.any"/></span></dt>
                                    <dd class="dropy__content">
                                        <ul>
                                            <li><a class="dropy__header"><spring:message code="search.age.any"/></a></li>
                                            <li><a>up to 1 year old</a></li>
                                            <li><a>up to 2 year old</a></li>
                                            <li><a>up to 3 year old</a></li>
                                            <li><a>up to 4 year old</a></li>
                                            <li><a>up to 5 year old</a></li>
                                            <li><a>up to 6 year old</a></li>
                                            <li><a>up to 7 year old</a></li>
                                            <li><a>up to 8 year old</a></li>
                                            <li><a>up to 9 year old</a></li>
                                            <li><a>up to 10 year old</a></li>
                                            <li><a>over 10 years old</a></li>
                                        </ul>
                                    </dd>
                                    <input type="hidden" name="first">
                                </dl>
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <div class="subdiv">
                                <dl class="dropy">
                                    <dt class="dropy__title"><span><spring:message code="search.mileage.any"/></span></dt>
                                    <dd class="dropy__content">
                                        <ul>
                                            <li><a class="dropy__header"><spring:message code="search.mileage.any"/></a></li>
                                            <li><a>up to 100 miles</a></li>
                                            <li><a>up to 500 miles</a></li>
                                            <li><a>up to 1,000 miles</a></li>
                                            <li><a>up to 5,000 miles</a></li>
                                            <li><a>up to 10,000 miles</a></li>
                                            <li><a>up to 20,000 miles</a></li>
                                            <li><a>up to 30,000 miles</a></li>
                                            <li><a>up to 40,000 miles</a></li>
                                            <li><a>up to 50,000 miles</a></li>
                                            <li><a>up to 60,000 miles</a></li>
                                            <li><a>up to 70,000 miles</a></li>
                                            <li><a>up to 80,000 miles</a></li>
                                            <li><a>up to 90,000 miles</a></li>
                                            <li><a>up to 100,000 miles</a></li>
                                            <li><a>over 100,000 miles</a></li>
                                        </ul>
                                    </dd>
                                    <input type="hidden" name="first">
                                </dl>
                            </div>
                        </div>

                    </div>

                    <div class="row justify-content-center">

                        <div class="col-sm-3">
                            <div class="subdiv">
                                <dl class="dropy">
                                    <dt class="dropy__title"><span><spring:message code="search.transmission.any"/></span></dt>
                                    <dd class="dropy__content">
                                        <ul id="filter_transmission">
                                            <li><a class="dropy__header"><spring:message code="search.transmission.any"/></a></li>
                                            <li><a>Automatic</a></li>
                                            <li><a>Manual</a></li>
                                            <li><a>Semi Automatic</a></li>
                                        </ul>
                                    </dd>
                                    <input type="hidden" name="first">
                                </dl>
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <div class="subdiv">
                                <dl class="dropy">
                                    <dt class="dropy__title"><span><spring:message code="search.fuel_type.any"/></span></dt>
                                    <dd class="dropy__content">
                                        <ul>
                                            <li><a class="dropy__header"><spring:message code="search.fuel_type.any"/></a></li>
                                            <li><a>petrol</a></li>
                                            <li><a>petrol/electric hybrid</a></li>
                                            <li><a>diesel</a></li>
                                            <li><a>diesel/electric hybrid</a></li>
                                            <li><a>electric</a></li>
                                        </ul>
                                    </dd>
                                    <input type="hidden" name="first">
                                </dl>
                            </div>
                        </div>

                    </div>
                </div>

            </div>


            <div class="colors">

                <div class="container">

                    <div class="row">
                        <div class="col-sm-3">
                            <p><strong><spring:message code="search.color"/></strong></p>
                        </div>
                    </div>

                    <div class="row no-gutters justify-content-center">

                        <div class="col-sm-auto m-multi">
                            <button title="beige" class="m-multi__item _beige"><span class="label">beige</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="black" class="m-multi__item _black"><span class="label">black</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="blue" class="m-multi__item _blue"><span class="label">blue</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="green" class="m-multi__item _green"><span class="label">green</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="grey" class="m-multi__item _grey"><span class="label">grey</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="orange" class="m-multi__item _orange"><span class="label">orange</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="pink" class="m-multi__item _pink"><span class="label">pink</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="purple" class="m-multi__item _purple"><span class="label">purple</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="red" class="m-multi__item _red"><span class="label">red</span></button>
                        </div>

                        <div class="col-sm-auto m-multi">
                            <button title="silver" class="m-multi__item _silver"><span class="label">silver</span></button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-sm-auto">
                    <a class="button b-search"><spring:message code="main.search"/></a>
                </div>
            </div>
        </section>

    </div>

    <div id="content" class="container">
        <div id='result' class="row"></div>
        <div class="row justify-content-center">
            <div class="col-sm-auto">
                <a class="button b-page"><spring:message code="main.more_results"/></a>
            </div>
        </div>
    </div>


    <div id="my-footer">
        <div class="main-footer">
            <div class="container">
                <div class="row justify-content-around">
                    <div class="col-sm-auto">
                        <a href="#" class="logo"><img src="/img/MyGarageLogo.svg" alt="MyGarage"></a>
                    </div>
                    <div class="col-sm-auto">
                        <div class="phone"><i class="fa fa-mobile"></i>+375 29 666-11-83</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="error_message">
    <p>Error</p>
</div>

<script src="/js/main_scripts_min.js"></script>
<script src="/js/common.js"></script>
<script src="/js/home.js"></script>
<script src="/js/error.js"></script>

</body>
</html>

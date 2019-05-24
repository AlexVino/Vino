<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
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

    <link rel="stylesheet" href="/css/main.block.min.css">
    <link rel="stylesheet" href="/css/error_block.css">
    <link rel="stylesheet" href="/css/main.min.css">

</head>
<body class="ishome">

<div id="my-page">

    <div id="my-header">
        <header class="site-header" style="background-image: url(img/aston-martin.jpg);">
            <div class="top-line boxShadow">
                <div class="container-fluid">
                    <div>
                        <div class="col-auto float-left"><a href="/" class="logo"><img src="/img/MyGarageLogo.svg" alt="MyGarage"></a></div>

                        <security:authorize access="isAnonymous()">
                            <div class="col-auto float-right"><a href="/signUp" class="button b-sign"><spring:message code="form.sign_in"/></a></div>
                        </security:authorize>
                        <security:authorize access="isAuthenticated()">
                            <div class="col-auto float-right"><a href="/logout" class="button b-sign"><spring:message code="main.log-out"/></a></div>
                            <div class="col-auto float-right"><a href="?" class="button b-sign"><%= request.getUserPrincipal().getName()%></a></div>
                            <div class="col-auto float-right"><a href="/orders" class="button b-sign"><spring:message code="orders.orders"/></a></div>
                        </security:authorize>

                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="col-auto float-right"><a id="btn-add" href="/ads/create" class="button b-sign"><spring:message code="cars.add"/></a></div>
                        </security:authorize>
                        
                        <!-- LANGUAGE BUTTON -->
                        <div class="col-auto switch-button float-right">
                            <span class="switch-active"></span>
                            <a href="?lang=<spring:message code="main.ru"/>"><button class="switch-button-case left active-case"><spring:message code="main.ru"/></button></a>
                            <a href="?lang=<spring:message code="main.en"/>"><button class="switch-button-case right"><spring:message code="main.en"/></button></a>
                        </div>
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
                            <button title="4x4" class="m-multi__item _4x4"><span class="label">4x4</span></button>
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
                            <button title="people-carrier" class="m-multi__item _peoplecarrier"><span class="label"><spring:message code="search.bodystyle.people-carrier"/></span></button>
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
                                        <ul id="filter_year">
                                            <li><a class="dropy__header"><spring:message code="search.age.any"/></a></li>
                                            <li><a title="1"><spring:message code="search.age.1"/></a></li>
                                            <li><a title="2"><spring:message code="search.age.2"/></a></li>
                                            <li><a title="3"><spring:message code="search.age.3"/></a></li>
                                            <li><a title="4"><spring:message code="search.age.4"/></a></li>
                                            <li><a title="5"><spring:message code="search.age.5"/></a></li>
                                            <li><a title="10"><spring:message code="search.age.10"/></a></li>
                                            <li><a title="15"><spring:message code="search.age.15"/></a></li>
                                            <li><a title="20"><spring:message code="search.age.20"/></a></li>
                                            <li><a title="25"><spring:message code="search.age.25"/></a></li>
                                            <li><a title="50"><spring:message code="search.age.50"/></a></li>
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
                                        <ul id="filter_mileage">
                                            <li><a class="dropy__header"><spring:message code="search.mileage.any"/></a></li>
                                            <li><a title="100"><spring:message code="search.mileage.100"/></a></li>
                                            <li><a title="500"><spring:message code="search.mileage.500"/></a></li>
                                            <li><a title="1000"><spring:message code="search.mileage.1000"/></a></li>
                                            <li><a title="5000"><spring:message code="search.mileage.5000"/></a></li>
                                            <li><a title="10000"><spring:message code="search.mileage.10000"/></a></li>
                                            <li><a title="20000"><spring:message code="search.mileage.20000"/></a></li>
                                            <li><a title="30000"><spring:message code="search.mileage.30000"/></a></li>
                                            <li><a title="40000"><spring:message code="search.mileage.40000"/></a></li>
                                            <li><a title="50000"><spring:message code="search.mileage.50000"/></a></li>
                                            <li><a title="60000"><spring:message code="search.mileage.60000"/></a></li>
                                            <li><a title="70000"><spring:message code="search.mileage.70000"/></a></li>
                                            <li><a title="80000"><spring:message code="search.mileage.80000"/></a></li>
                                            <li><a title="90000"><spring:message code="search.mileage.90000"/></a></li>
                                            <li><a title="100000"><spring:message code="search.mileage.100000"/></a></li>
                                            <li><a title="100001"><spring:message code="search.mileage.100001"/></a></li>
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
                                            <li><a title="Automatic"><spring:message code="search.transmission.automatic"/></a></li>
                                            <li><a title="Manual"><spring:message code="search.transmission.manual"/></a></li>
                                            <li><a title="Semi Automatic"><spring:message code="search.transmission.semi-automatic"/></a></li>
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
                                        <ul id="filter_fueltype">
                                            <li><a class="dropy__header"><spring:message code="search.fuel_type.any"/></a></li>
                                            <li><a title="petrol"><spring:message code="search.fuel_type.petrol"/></a></li>
                                            <li><a title="petrol-electric-hybrid"><spring:message code="search.fuel_type.petrol-electric-hybrid"/></a></li>
                                            <li><a title="diesel"><spring:message code="search.fuel_type.diesel"/></a></li>
                                            <li><a title="diesel-electric-hybrid"><spring:message code="search.fuel_type.diesel-electric-hybrid"/></a></li>
                                            <li><a title="electric"><spring:message code="search.fuel_type.electric"/></a></li>
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
                            <button title="gray" class="m-multi__item _gray"><span class="label">gray</span></button>
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

<input type="hidden" id="full-details" value="<spring:message code="main.full-details"/>">
<input type="hidden" id="mileage" value="<spring:message code="cars.mileage"/>">

<script src="/js/main_scripts_min.js"></script>
<script src="/js/common.js"></script>
<script src="/js/home.js"></script>
<script src="/js/error.js"></script>

</body>
</html>

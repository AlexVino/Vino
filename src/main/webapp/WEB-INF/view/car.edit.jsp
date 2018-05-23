<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <link rel="stylesheet" href="/css/main.min.css">
    <link rel="stylesheet" href="/css/error_block.css">
    <link rel="stylesheet" href="/css/main.min.car.add.css">

</head>

<body class="ishome">

<c:import url="header.jsp"/>

<div id="my-content">

    <div class="container">

        <div class="row justify-content-between">
            <div class="col-md-8 col-xs-12">
                <img id="myimage" src="${car.image}" width="100%">
            </div>

            <div class="col-md-4 col-xs-12">
                <button class="button" id="btn-img">
                    <spring:message code="cars.select-image"/>
                </button>
                <input id="input-img" type="file" accept="image/*" onchange="onFileSelected(event)" style="visibility: hidden">
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <dl class="dropy">
                        <dt class="dropy__title"><span class="span_makes"><spring:message code="search.make.any"/></span></dt>
                        <dd class="dropy__content">
                            <ul id="filter_makes">
                                <li><a class="dropy__header"><spring:message code="search.make.any"/></a></li>
                            </ul>
                        </dd>
                        <input type="hidden" name="first">
                    </dl>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <dl class="dropy">
                        <dt class="dropy__title"><span class="span_models"><spring:message code="search.model.any"/></span></dt>
                        <dd class="dropy__content">
                            <ul id="filter_models">
                                <li><a class="dropy__header"><spring:message code="search.model.any"/></a></li>
                                <li><a>-------</a></li>
                            </ul>
                        </dd>
                        <input type="hidden" name="first"/>
                    </dl>
                </div>
            </div>


            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <dl class="dropy">
                        <dt class="dropy__title"><span class="span_bodystyle"><spring:message code="search.bodystyle"/></span></dt>
                        <dd class="dropy__content">
                            <ul id="filter_bodystyle">
                                <li><a class="dropy__header"><spring:message code="search.bodystyle"/></a></li>
                                <li><a title="4x4">4x4</a></li>
                                <li><a title="convertible"><spring:message code="search.bodystyle.convertible"/></a></li>
                                <li><a title="coupe"><spring:message code="search.bodystyle.coupe"/></a></li>
                                <li><a title="estate"><spring:message code="search.bodystyle.estate"/></a></li>
                                <li><a title="hatchback"><spring:message code="search.bodystyle.hatchback"/></a></li>
                                <li><a title="people carrier"><spring:message code="search.bodystyle.people-carrier"/></a></li>
                                <li><a title="pick-up"><spring:message code="search.bodystyle.pick-up"/></a></li>
                                <li><a title="saloon"><spring:message code="search.bodystyle.saloon"/></a></li>
                            </ul>
                        </dd>
                        <input type="hidden" name="first">
                    </dl>
                </div>
            </div>




            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <dl class="dropy">
                        <dt class="dropy__title"><span class="span_transmission"><spring:message code="search.transmission.any"/></span></dt>
                        <dd class="dropy__content">
                            <ul id="filter_transmission">
                                <li><a class="dropy__header"><spring:message code="search.transmission.any"/></a></li>
                                <li><a title="automatic"><spring:message code="search.transmission.automatic"/></a></li>
                                <li><a title="manual"><spring:message code="search.transmission.manual"/></a></li>
                                <li><a title="semi-automatic"><spring:message code="search.transmission.semi-automatic"/></a></li>
                            </ul>
                        </dd>
                        <input type="hidden" name="first">
                    </dl>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <dl class="dropy">
                        <dt class="dropy__title"><span class="span_fuel"><spring:message code="search.fuel_type.any"/></span></dt>
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


            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <dl class="dropy">
                        <dt class="dropy__title"><span class="span_color"><spring:message code="search.color"/></span></dt>
                        <dd class="dropy__content">
                            <ul id="filter_color">
                                <li><a class="dropy__header"><spring:message code="search.color"/></a></li>
                                <li><a title="beige"><spring:message code="color.beige"/></a></li>
                                <li><a title="black"><spring:message code="color.black"/></a></li>
                                <li><a title="blue"><spring:message code="color.blue"/></a></li>
                                <li><a title="green"><spring:message code="color.green"/></a></li>
                                <li><a title="grey"><spring:message code="color.grey"/></a></li>
                                <li><a title="orange"><spring:message code="color.orange"/></a></li>
                                <li><a title="pink"><spring:message code="color.pink"/></a></li>
                                <li><a title="purple"><spring:message code="color.purple"/></a></li>
                                <li><a title="red"><spring:message code="color.red"/></a></li>
                                <li><a title="silver"><spring:message code="color.silver"/></a></li>
                            </ul>
                        </dd>
                        <input type="hidden" name="first">
                    </dl>
                </div>
            </div>

        </div>

        <div class="row inputs">

            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="main.price"/><span class="req">*</span>
                    </label>
                    <input type="text" id="price" step="1" min="0" max="1000000000" maxlength="10" required autocomplete="off" />
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="cars.mileage"/><span class="req">*</span>
                    </label>
                    <input type="text" id="mileage" step="1" min="0" max="1000000000" maxlength="10" required autocomplete="off" />
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="cars.year"/><span class="req">*</span>
                    </label>
                    <input type="number" step="1" id="year" min="1800" max="2100" maxlength="4" required autocomplete="off" />
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="cars.engine"/><span class="req">*</span>
                    </label>
                    <input type="number"  min="0" max="1000" maxlength="10" id="engine" required autocomplete="off" />
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="cars.description"/><span class="req">*</span>
                    </label>
                    <input type="text" id="description" maxlength="1000" required autocomplete="off" />
                </div>
            </div>

            <div class="col-md-4 col-xs-1" id="upload-button">
                <button id="add" class="button upload"><spring:message code="cars.add"/></button>
            </div>
        </div>
    </div>
</div>


<div id="main-footer">
    <div class="container-fluid">
        <div class="row justify-content-around">

            <div class="col-auto">
                <a href="#" class="logo"><img src="/img/MyGarageLogo.svg" alt="MyGarage"></a>
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
<input type="hidden" id="username" value="">
<input type="hidden" id="carid" value="${car.carId}">

<script src="/js/scripts.min.car.create.js"></script>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/common.js"></script>
<script src="/js/car.edit.js"></script>
<script src="/js/error.js"></script>

</body>
</html>
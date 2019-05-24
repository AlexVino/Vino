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

    <link rel="stylesheet" href="/css/error_block.css">
    <link rel="stylesheet" href="/css/main.min.car.add.css">
    <link rel="stylesheet" href="/css/main.min.new.css">

</head>

<body class="ishome">

<c:import url="header.jsp"/>

<div id="my-content">

    <div class="container">

        <div class="row justify-content-between">
            <div class="col-md-8 col-xs-12">
                <img id="myimage" src="${car.image}" style="max-height: 500px; max-width: 500px">
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
                                <li><a title="gray"><spring:message code="color.gray"/></a></li>
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

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <dl class="dropy">
                        <dt class="dropy__title"><span class="span_drivetype"><spring:message code="search.drivetype.any"/></span></dt>
                        <dd class="dropy__content">
                            <ul id="filter_drivetype">
                                <li><a class="dropy__header"><spring:message code="search.drivetype.any"/></a></li>
                                <li><a title="full"><spring:message code="search.drivetype.full"/></a></li>
                                <li><a title="front"><spring:message code="search.drivetype.front"/></a></li>
                                <li><a title="back"><spring:message code="search.drivetype.back"/></a></li>
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
                    <label  class="active">
                        <spring:message code="cars.complectation"/><span class="req">*</span>
                    </label>
                    <input type="text" maxlength="10" id="complectation" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="main.price"/><span class="req">*</span>
                    </label>
                    <input type="text" id="price" maxlength="10" required autocomplete="off" />
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="main.rrPrice"/>
                    </label>
                    <input type="text" id="rrPrice" maxlength="10" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.vin"/><span class="req">*</span>
                    </label>
                    <input type="text" maxlength="17" id="vin" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.mileage"/>
                    </label>
                    <input type="text" id="mileage" step="1" min="0" max="1000000000" maxlength="10" required autocomplete="off" />
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.year"/><span class="req">*</span>
                    </label>
                    <input type="text" id="year" maxlength="4" required autocomplete="off" />
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.enginevolume"/><span class="req">*</span>
                    </label>
                    <input type="text" maxlength="10" id="enginevolume" required autocomplete="off" />
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.horsepower"/> <spring:message code="cars.hp"/><span class="req">*</span>
                    </label>
                    <input type="text" maxlength="10" id="horsepower" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.maxspeed"/> <spring:message code="cars.kmh"/>
                    </label>
                    <input type="text" maxlength="10" id="maxspeed" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.commonconsumption"/> <spring:message code="cars.litre"/>
                    </label>
                    <input type="text" maxlength="10" id="commonconsumption" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.cityconsumption"/> <spring:message code="cars.litre"/>
                    </label>
                    <input type="text" maxlength="10" id="cityconsumption" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.routeconsumption"/> <spring:message code="cars.litre"/>
                    </label>
                    <input type="text" maxlength="10" id="routeconsumption" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.acceleration"/> <spring:message code="cars.second"/>
                    </label>
                    <input type="text" maxlength="10" id="acceleration" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.length"/> <spring:message code="cars.mm"/>
                    </label>
                    <input type="text" maxlength="10" id="length" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-4 col-xs-1">
                <div class="field-wrap">
                    <label  class="active">
                        <spring:message code="cars.width"/> <spring:message code="cars.mm"/>
                    </label>
                    <input type="text" maxlength="10" id="width" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-12 col-xs-1">
                <div class="field-wrap">
                    <label class="active">
                        <spring:message code="cars.description"/><span class="req">*</span>
                    </label>
                    <input type="text" aria-multiline="true" aria-rowcount="4" id="description" maxlength="1000" required autocomplete="off" />
                </div>
            </div>

        </div>


        <div class="options-checkboxes__group-head">
            <div class="options-checkboxes__groupname"><spring:message code="search.visibility"/></div>
            <div class="options-checkboxes__delimiter">
                <div class="options-checkboxes__line"></div>
            </div>
        </div>

        <div class="row justify-content-between">

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <dl class="dropy">
                        <dt class="dropy__title"><span class="span_headlights"><spring:message code="search.headlights.any"/></span></dt>
                        <dd class="dropy__content">
                            <ul id="filter_headlights">
                                <li><a class="dropy__header"><spring:message code="search.headlights.any"/></a></li>
                                <li><a title="xenon"><spring:message code="search.headlights.xenon"/></a></li>
                                <li><a title="laser"><spring:message code="search.headlights.laser"/></a></li>
                                <li><a title="led"><spring:message code="search.headlights.led"/></a></li>
                            </ul>
                        </dd>
                        <input type="hidden" name="first">
                    </dl>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.electricheatingofthewindshield"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchElectricheatingofthewindshield">
                        <label class="onoffswitch-label" for="myonoffswitchElectricheatingofthewindshield"></label>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.electricheatingofsidemirrors"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchElectricheatingofsidemirrors">
                        <label class="onoffswitch-label" for="myonoffswitchElectricheatingofsidemirrors"></label>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.headlightwashersystem"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchHeadlightwashersystem">
                        <label class="onoffswitch-label" for="myonoffswitchHeadlightwashersystem"></label>
                    </div>
                </div>
            </div>


            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.rainsensor"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchRainsensor">
                        <label class="onoffswitch-label" for="myonoffswitchRainsensor"></label>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.foglight"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchFoglight">
                        <label class="onoffswitch-label" for="myonoffswitchFoglight"></label>
                    </div>
                </div>
            </div>

        </div>

        <div class="options-checkboxes__group-head">
            <div class="options-checkboxes__groupname"><spring:message code="search.multimedia"/></div>
            <div class="options-checkboxes__delimiter">
                <div class="options-checkboxes__line"></div>
            </div>
        </div>

        <div class="row justify-content-between">

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.bluetooth"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchBluetooth">
                        <label class="onoffswitch-label" for="myonoffswitchBluetooth"></label>
                    </div>
                </div>
            </div>


            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.usb"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchUSB">
                        <label class="onoffswitch-label" for="myonoffswitchUSB"></label>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.aux"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchAUX">
                        <label class="onoffswitch-label" for="myonoffswitchAUX"></label>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.navigationsystem"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchNavigationsystem">
                        <label class="onoffswitch-label" for="myonoffswitchNavigationsystem"></label>
                    </div>
                </div>
            </div>

        </div>

        <div class="options-checkboxes__group-head">
            <div class="options-checkboxes__groupname"><spring:message code="search.comfort"/></div>
            <div class="options-checkboxes__delimiter">
                <div class="options-checkboxes__line"></div>
            </div>
        </div>

        <div class="row justify-content-between">

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.cruisecontrol"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchCruisecontrol">
                        <label class="onoffswitch-label" for="myonoffswitchCruisecontrol"></label>
                    </div>
                </div>
            </div>


            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.parktronic"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchParktronic">
                        <label class="onoffswitch-label" for="myonoffswitchParktronic"></label>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.climatecontrol"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchClimatecontrol">
                        <label class="onoffswitch-label" for="myonoffswitchClimatecontrol"></label>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.powerWindows"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchPowerWindows">
                        <label class="onoffswitch-label" for="myonoffswitchPowerWindows"></label>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-1">
                <div class="subdiv">
                    <label style="display: flex">
                        <spring:message code="search.steeringadjustment"/>
                    </label>
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitchsteeringadjustment">
                        <label class="onoffswitch-label" for="myonoffswitchsteeringadjustment"></label>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-1" id="upload-button">
                <button id="add" class="button upload"><spring:message code="cars.add"/></button>
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
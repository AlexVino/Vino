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

    <!--<link rel="stylesheet" href="/css/main.min.css">-->
    <link rel="stylesheet" href="/css/error_block.css">
    <link rel="stylesheet" href="/css/main.min.car.add.css">
    <link rel="stylesheet" href="/css/main.min.new.css">

</head>

<body class="ishome">

<c:import url="header.jsp"/>

<div id="my-content">

    <div class="container">

        <div class="options-checkboxes__group-head">
            <div class="options-checkboxes__groupname"><spring:message code="form.create_dealer"/></div>
            <div class="options-checkboxes__delimiter">
                <div class="options-checkboxes__line"></div>
            </div>
        </div>

        <div class="row inputs">

            <div class="col-md-12 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="form.username"/><span class="req">*</span>
                    </label>
                    <input type="text" maxlength="10" id="new-username" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-6 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="form.firstname"/><span class="req">*</span>
                    </label>
                    <input type="text" id="firstname" maxlength="10" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-6 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="form.lastname"/><span class="req">*</span>
                    </label>
                    <input type="text" id="lastname" maxlength="10" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-6 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="form.phone"/><span class="req">*</span>
                    </label>
                    <input type="text" maxlength="10" id="telephone" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-6 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="form.email"/><span class="req">*</span>
                    </label>
                    <input type="text" id="email" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-6 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="form.password"/><span class="req">*</span>
                    </label>
                    <input type="text" maxlength="20" id="new-password" required autocomplete="off"/>
                </div>
            </div>
            <div class="col-md-6 col-xs-1">
                <div class="field-wrap">
                    <label>
                        <spring:message code="form.confirm_password"/><span class="req">*</span>
                    </label>
                    <input type="text" maxlength="20" id="confirm-password" required autocomplete="off"/>
                </div>
            </div>

            <div class="col-md-12 col-xs-1">
                <div class="row justify-content-center">
                    <div class="col-md-3 col-xs-1" id="upload-button">
                        <button id="add" class="button upload"><spring:message code="dealer.add"/></button>
                    </div>
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

<!--<script src="/js/scripts.min.car.create.js"></script>-->
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/common.js"></script>
<script src="/js/dealer.create.js"></script>
<script src="/js/error.js"></script>

</body>
</html>
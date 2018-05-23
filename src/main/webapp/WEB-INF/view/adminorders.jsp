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

    <link rel="stylesheet" href="/css/main.min.new.css">
    <link rel="stylesheet" href="/css/error_block.css">
</head>

<body class="ishome">

<c:import url="header.jsp"/>

<div id="my-content">
    <div class="container">
        <div class="row">
            <div class="col">
                <section id="orders">
                    <div class="tbl-header">
                        <table cellpadding="0" cellspacing="0" border="0">
                            <thead>
                            <tr>
                                <th>№</th>
                                <th><spring:message code="form.firstname"/></th>
                                <th><spring:message code="form.lastname"/></th>
                                <th><spring:message code="form.phone"/></th>
                                <th><spring:message code="main.name"/></th>
                                <th><spring:message code="main.price"/></th>
                                <th><spring:message code="main.select"/></th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                    <div class="tbl-content">
                        <table cellpadding="0" cellspacing="0" border="0">
                            <tbody id="result">
                            </tbody>
                        </table>
                    </div>
                </section>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-auto"><a id="cancel" class="button"><spring:message code="main.complete"/></a></div>
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

<script src="/js/scripts.min.js"></script>
<script src="/js/adminorders.js"></script>
<script src="/js/error.js"></script>

</body>
</html>

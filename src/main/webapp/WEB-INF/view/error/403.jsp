<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">

  <title>403</title>
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
  <link rel="stylesheet" href="/css/error.min.css">

</head>

<body class="ishome">

<c:import url="../header.jsp"/>

  <div id="my-content">
      <div class="container">
        <div class="row">
          <div class="brick col-xs-hidden"></div>

            <div class="col-md-6 col-xs-hidden"></div>
            <div class="col-md-6 col-xs-12" align="center">
                <div class="four"></div>
                <div class="zero">
                    <div class="nail"></div>
                </div>
                <div class="three number"></div>
            </div>

            <div class="col-md-6 col-xs-hidden"></div>
              <div class="info col-md-6 col-xs-12">
                  <h2><spring:message code="main.403.h"/></h2>
                  <p><spring:message code="main.403.p"/></p>
                  <a href="/" class="button"><spring:message code="main.home"/></a>
            </div>
      </div>
    </div>
  </div>

  <footer id="footer">
    <div class="container">
      <div class="row">
        <!-- Worker -->
        <div class="worker"></div>
        <!-- Tools -->
        <div class="tools"></div>
      </div>
    </div>
  </footer>

</body>
</html>
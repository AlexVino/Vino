<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">

  <title>404</title>
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

  <link rel="stylesheet" href="/css/error.min.css">

</head>

<body class="ishome">

<c:import url="header.jsp"/>

  <div id="my-content">
      <div class="container">
        <div class="row">
          <div class="brick col-xs-hidden"></div>

            <div class="col-md-6 col-xs-hidden"></div>
            <div class="col-md-6 col-xs-12" align="center">
                <div class="four "></div>
                <div class="zero ">
                    <div class="nail "></div>
                </div>
                <div class="four number"></div>
            </div>

            <div class="col-md-6 col-xs-hidden"></div>
              <div class="info col-md-6 col-xs-12">
                  <h2>Something is wrong</h2>
                  <p>The page you are looking for was moved, removed, renamed or might never existed.</p>
                  <a href="/" class="button">Go Home</a>
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
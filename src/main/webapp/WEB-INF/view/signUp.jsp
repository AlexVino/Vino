<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="utf-8">

  <title>SignIn</title>
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

</head>

<body class="ishome">

  <header class="site-header registration">
    <div class="top-line boxShadow">
      <div class="container">
        <div class="row justify-content-between">
          <div class="col-sm-9"><a href="/" class="logo"><img src="/img/MyGarageLogo.svg" alt="MyGarage"></a></div>
          <div class="col-sm-2"><a href="#" class="button b-sign">Sign in</a></div>
        </div>
      </div>
    </div>
  </header>

  <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>SIGN-UP TO A MYGARAGE ACCOUNT</h1>
  
          <form action="/" method="post">
  
            <div class="top-row">
              <div class="field-wrap">
                <label>
                  First Name<span class="req">*</span>
                </label>
                <input type="text" required autocomplete="off" />
              </div>
          
              <div class="field-wrap">
                <label>
                  Last Name<span class="req">*</span>
                </label>
                <input type="text" required autocomplete="off"/>
              </div>
            </div>

            <div class="field-wrap">
              <label>
                Phone number<span class="req">*</span>
              </label>
              <input type="tel" required autocomplete="off"/>
            </div>
            
            <div class="field-wrap">
              <label>
                Username<span class="req">*</span>
              </label>
              <input type="text" required autocomplete="off"/>
            </div>

            <div class="top-row">
              <div class="field-wrap">
                <label>
                  Password<span class="req">*</span>
                </label>
                <input type="password" required autocomplete="off" />
              </div>
          
              <div class="field-wrap">
                <label>
                  Confirm password<span class="req">*</span>
                </label>
                <input type="password" required autocomplete="off"/>
              </div>
            </div>
            
            <button type="submit" class="r-button button-block">Get Started</button>
          
          </form>

        </div>
        
        <div id="login">   
          <h1>RETURNING USER</h1>

          <form action="/j_spring_security_check" method="post">

          <div class="field-wrap">
            <label>
              Username<span class="req">*</span>
            </label>
            <input type="text" id ="username" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" required autocomplete="off"/>
          </div>
          
          <button type="submit" class="r-button button-block">Log In</button>
          
          </form>
        </div>
      </div>
  </div>

  <script src="/js/scripts.min.js"></script>

</body>
</html>
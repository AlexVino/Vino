<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
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
  <link rel="stylesheet" href="/css/error_block.css">

</head>

<body class="ishome">

<c:import url="header.jsp"/>

  <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup"><spring:message code="form.sign_up"/></a></li>
        <li class="tab"><a href="#login"><spring:message code="form.log_in"/></a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1><spring:message code="form.sugn_up_h1"/></h1>
  
          <form>
            <div class="top-row">
              <div class="field-wrap">
                <label for="firstname">
                  <spring:message code="form.firstname"/><span class="req">*</span>
                </label>
                <input type="text" id="firstname" required autocomplete="off" />
              </div>
          
              <div class="field-wrap">
                <label for="lastname">
                  <spring:message code="form.lastname"/><span class="req">*</span>
                </label>
                <input type="text" id="lastname" required autocomplete="off"/>
              </div>
            </div>

            <div class="field-wrap">
              <label for="telephone">
                <spring:message code="form.phone"/><span class="req">*</span>
              </label>
              <input type="tel" id="telephone" required autocomplete="off"/>
            </div>
            
            <div class="field-wrap">
              <label for="new-username">
                <spring:message code="form.username"/><span class="req">*</span>
              </label>
              <input type="text" id="new-username" required autocomplete="off"/>
            </div>

            <div class="top-row">
              <div class="field-wrap">
                <label for="new-password">
                  <spring:message code="form.password"/><span class="req">*</span>
                </label>
                <input type="password" id="new-password" required autocomplete="off" />
              </div>
          
              <div class="field-wrap">
                <label for="confirm-password">
                  <spring:message code="form.confirm_password"/><span class="req">*</span>
                </label>
                <input type="password" id="confirm-password" required autocomplete="off"/>
              </div>
            </div>

            <button type="button" id="btnSignUp" class="r-button button-block"><spring:message code="form.get_started"/></button>
          
          </form>

        </div>
        
        <div id="login">   
          <h1><spring:message code="form.returning_user"/></h1>

          <form action="/j_spring_security_check" method="post">

          <div class="field-wrap">
            <label for="username">
              <spring:message code="form.username"/><span class="req">*</span>
            </label>
            <input type="text" id ="username" name="username" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label for="password">
              <spring:message code="form.password"/><span class="req">*</span>
            </label>
            <input type="password" id="password" name="password" required autocomplete="off"/>
          </div>
          
          <button type="submit" class="r-button button-block"><spring:message code="form.log_in"/></button>
          </form>
        </div>
      </div>
  </div>

  <div class="error_message">
    <p>Error</p>
  </div>

  <input type="hidden" id="error-login-or-password" value="<spring:message code="main.error-login-or-password"/>">
  <input type="hidden" id="error-password" value="<spring:message code="form.password_confirm"/>">

  <script src="/js/signUp_scripts_min.js"></script>
  <script src="/js/jquery-3.3.1.min.js"></script>
  <script src="/js/signUp.js"></script>
  <script src="/js/error.js"></script>

</body>
</html>
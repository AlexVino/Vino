<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<header class="site-header registration">
    <div class="top-line boxShadow">
        <div class="container-fluid">
            <div>
                <div class="col-auto float-left"><a href="/" class="logo"><img src="/img/MyGarageLogo.svg" alt="MyGarage"></a></div>

                <security:authorize access="isAnonymous()">
                    <div class="col-auto float-right"><a href="/signUp" class="button b-sign"><spring:message code="form.sign_in"/></a></div>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <div class="col-auto float-right"><a href="/logout" class="button b-sign"><spring:message code="main.log-out"/></a></div>
                    <div class="col-auto float-right"><a href="#" class="button b-sign"><%= request.getUserPrincipal().getName()%></a></div>
                    <div class="col-auto float-right"><a href="/orders" class="button b-sign"><spring:message code="orders.orders"/></a></div>
                </security:authorize>

                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <div class="col-auto float-right"><a id="btn-add" href="/cars/create" class="button b-sign"><spring:message code="cars.add"/></a></div>
                </security:authorize>

                <input type="hidden" id="username" value="<%= request.getUserPrincipal().getName()%>">

                <!-- LANGUAGE BUTTON -->
                <div class="col-auto switch-button float-right">
                    <span class="switch-active"></span>
                    <a href="?lang=ru"><button class="switch-button-case left active-case"><spring:message code="main.ru"/></button></a>
                    <a href="?lang=en"><button class="switch-button-case right"><spring:message code="main.en"/></button></a>
                </div>
            </div>
        </div>
    </div>
</header>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Regisztráció!</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>    
    <link type="text/css" rel="stylesheet" href="/resources/static/css/registration.css"/>

</head>
<body>
    <img src="/resources/images/mourinho.png" alt="" />
    <img src="/resources/images/klopp.png" class="kep"/>
<form:form action="/registration" modelAttribute="userReg" method="POST" class="form-signin">
    <div class="topnav">
        <a href="home"><span class="glyphicon glyphicon-home "></span> Kezdőlap</a>
        <div class="nav navbar-right">
            <a class="active" href="registration"><span class="glyphicon glyphicon-user "></span> Regisztráció</a>
            <a href="login"><span class="glyphicon glyphicon-log-in "></span> Bejelentkezés</a>
        </div>
        
    </div>
    
    <div class="card center-block">
                <h2>Regisztráció</h2>
        
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}" style="font-size: 10px;">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}" style="font-size: 10px;">
                <form:input type="password" path="password" class="form-control" placeholder="Jelszó"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>
            
        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}" style="font-size: 10px;">
                <form:input type="password" path="confirmPassword" class="form-control" placeholder="Jelszó"></form:input>
                <form:errors path="confirmPassword"></form:errors>
            </div>
        </spring:bind>  
            
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}" style="font-size: 10px;">
                <form:input type="text" path="firstName" class="form-control" placeholder="Vezetéknév"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>
            
        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}" style="font-size: 10px;">
                <form:input type="text" path="lastName" class="form-control" placeholder="Keresztnév"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>
            
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}" style="font-size: 10px;">
                <form:input type="text" path="email" class="form-control" placeholder="e-mail"></form:input>
                <form:errors path="email"></form:errors>
            </div><div style="color: red">${error}</div>
        </spring:bind>
            
            <div style="text-align:center;">
                <button type="submit" class="login_btn center-block" style="border-radius: 12px;">Regisztráció</button>
            </div>
            
            <div class="card-footer" style="text-align:center;">
            </div>
</form:form>
            <div class="d-flex justify-content-center links ">   
                    <h3>Mégis van felhasználód?<a href="/login">Bejelentkezés</a></h3>
                </div>
    </div>
</body>
</html>
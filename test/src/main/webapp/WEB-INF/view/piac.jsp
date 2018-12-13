<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Piac</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/static/css/piac.css"/>
    <script type="text/javascript" src="/resources/static/js/piac.js"></script>

</head>

<body>
        <div class="topnav">
        <a href="result">Adataim</a>
        <a href="myteam">Saját csapatom</a>
        <a href="enemy">Ellenfél csapata</a>
        <a class="active" href="piac">Átigazolási piac</a>
        <a href="players">Játék</a>
        <div class="nav navbar-right">
            <a href="logout"><span class="glyphicon glyphicon-log-out"></span> Kilépés</a>
        </div>
    </div>
    
<h1>Átigazolási piac</h1>
        <h1>Pénzed: ${money} millió euró</h1>
<h1>Kapusok</h1>

<form:form name="leker" method="POST" class="form-signin" >
    <table>
        <c:forEach var="kapusok" items="${kapus_kiir}" varStatus="status">
            <tr>
                <td>
                    <c:out value="${kapusok.nev}" />
                </td>
                <td>
                    <c:out value="${kapusok.rang}"/>
                </td>
                <td>
                    <c:out value="${kapusok.ertek}"/>
                </td>
                <td>
                    <input type="checkbox" name="selected" value="${kapusok.nev}">
                </td>
            </tr>
        </c:forEach>
   </table>

    <button type="submit" class="btn btn-dark btn-rounded">Mentés</button>   
<h1>Védők: </h1>
    <table>
        <c:forEach var="vedok" items="${vedo_kiir}" varStatus="status">
            <tr>
            <td>
                <c:out value="${vedok.nev}" />
            </td>
            <td>
                <c:out value="${vedok.rang}"/>
            </td>
            <td>
                <c:out value="${vedok.ertek}"/>
            </td>
            <td>
                <input type="checkbox" name="selected_vedok" value="${vedok.nev}">
            </td>
            </tr>
        </c:forEach>
   </table>
    <button type="submit" class="btn btn-dark btn-rounded">Mentés</button>

<h1>Középpályások: </h1>
    <table>
        <c:forEach var="kozepek" items="${kozep_kiir}" varStatus="status">
            <tr>
            <td>
                <c:out value="${kozepek.nev}" />
            </td>
            <td>
                <c:out value="${kozepek.rang}"/>
            </td>
            <td>
                <c:out value="${kozepek.ertek}"/>
            </td>
            <td>
                <input type="checkbox" name="selected_kozepek" value="${kozepek.nev}">
            </td>
            </tr>
        </c:forEach>
   </table>
    <button type="submit" class="btn btn-dark btn-rounded">Mentés</button>
<h1>Támadók</h1>
<table>
         <c:forEach var="tamadok" items="${tamado_kiir}" varStatus="status">
            <tr>
            <td>
                <c:out value="${tamadok.nev}" />
            </td>
            <td>
                <c:out value="${tamadok.rang}"/>
            </td>
            <td>
                <c:out value="${tamadok.ertek}"/>
            </td>
            <td>
                <input type="checkbox" name="selected_tamadok" value="${tamadok.nev}">
            </td>
            </tr>
        </c:forEach>
   </table>
    <button type="submit" class="btn btn-dark btn-rounded">Mentés</button>
        </form:form>
</body>
</html>


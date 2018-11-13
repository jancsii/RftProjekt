<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
    <script type="text/javascript">
        $(document).ready(function () {
            $('#kapus_poszt').change(function () {
                var selectedOption = $('#kapus_poszt option:selected');
                $('#kapuss').html('Igazolas = ' + selectedOption.text());
                $('#kapuss').css("color", "red");
                $('#kapuss').css( "fontSize", "10px" );
            });
             $('#vedo_poszt').change(function () {
                var selectedOption = $('#vedo_poszt option:selected');
                $('#vedoo').html('Igazolas = ' + selectedOption.text());
                $('#vedoo').css("color", "red");
                $('#vedoo').css( "fontSize", "10px" );
            });
            $('#kozepes_poszt').change(function () {
                var selectedOption = $('#kozepes_poszt option:selected');
                $('#kozepp').html('Igazolas = ' + selectedOption.text());
                $('#kozepp').css("color", "red");
                $('#kozepp').css( "fontSize", "10px" );
            });
            $('#tamado_poszt').change(function () {
                var selectedOption = $('#tamado_poszt option:selected');
                $('#tamadoo').html('Igazolas = ' + selectedOption.text());
                $('#tamadoo').css("color", "red");
                $('#tamadoo').css( "fontSize", "10px" );
            });
$('input[type="checkbox"]').on('change', function() {
    $('input[name="' + this.name + '"]').not(this).prop('checked', false);
});
        });
    </script>
    <style>
        table {
    border-collapse: separate;
    margin: 10px auto;
    color: black;
    width: 50%;
    top: auto;
}

td {
    text-align: center;
    padding: 8px;
    opacity: 40%;
}

tr:nth-child(even){
    background-color: rgba(255, 255, 255, .3);
}
    </style>
</head>

<body>
        <div class="topnav">
        <a class="active" href="result">Kezdolap</a>
        <a href="players">Jatek</a>
        <a href="myteam">Csapatom</a>
        <a href="enemy">Ellenfel</a>
        <a href="piac">Piac</a>
        <a href="kilepes">Kilepes</a>
        <div class="nav navbar-right">
            <a href="registration"><span class="glyphicon glyphicon-user "></span> Sign Up</a>
            <a href="login"><span class="glyphicon glyphicon-log-in "></span> Login</a>
        </div>
    </div>
    
<h1>Átigazolási piac</h1>
<h1>Kapusok</h1>

<form:form name="leker" method="POST" class="form-signin" >
    <table>
        <c:forEach var="kapusok" items="${kapus_kiir}">
            <tr>
            <td>
                <c:out value="${kapusok}" />
            </td>
            <td>
                Semmi.
            </td>
            <td>
                <input type="checkbox" name="selected" value="${kapusok}">
            </td>
            </tr>
        </c:forEach>
   </table>

    <button type="submit" class="btn btn-dark btn-rounded">Mentés</button>   
<h1>Vedok: </h1>
    <table>
        <c:forEach var="vedok" items="${vedo_kiir}">
            <tr>
            <td>
                <c:out value="${vedok}" />
            </td>
            <td>
                Semmi.
            </td>
            <td>
                <input type="checkbox" name="selected_vedok" value="${vedok}">
            </td>
            </tr>
        </c:forEach>
   </table>
    <button type="submit" class="btn btn-dark btn-rounded">Mentés</button>

<h1>Kozeppalyasok: </h1>
    <table>
        <c:forEach var="kozepek" items="${kozep_kiir}">
            <tr>
            <td>
                <c:out value="${kozepek}" />
            </td>
            <td>
                Semmi.
            </td>
            <td>
                <input type="checkbox" name="selected_kozepek" value="${kozepek}">
            </td>
            </tr>
        </c:forEach>
   </table>
    <button type="submit" class="btn btn-dark btn-rounded">Mentés</button>
<h2>Tamadok: </h2>
<table>
         <c:forEach var="tamadok" items="${tamado_kiir}">
            <tr>
            <td>
                <c:out value="${tamadok}" />
            </td>
            <td>
                Semmi.
            </td>
            <td>
                <input type="checkbox" name="selected_tamadok" value="${tamadok}">
            </td>
            </tr>
        </c:forEach>
   </table>
    <button type="submit" class="btn btn-dark btn-rounded">Mentés</button>
        </form:form>
</body>
</html>


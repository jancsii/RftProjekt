<%@page contentType = "text/html; charset=UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Adataim</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/static/css/result.css"/>

</head>


<body>
        <div class="topnav">
        <a class="active" href="result">Adataim</a>
        <a href="myteam">Saját csapatom</a>
        <a href="piac">Átigazolási piac</a>
        <a href="players">Játék</a>
        <div class="nav navbar-right">
            <a href="logout"><span class="glyphicon glyphicon-log-out"></span> Kilépés</a>
        </div>
    </div>
<h2>A felhasznaló adatai</h2>
<h3></h3>
<table>
    <tr>
        <td>Felhasználónév: </td>
        <td>${username}</td>
    </tr>
    <tr>
        <td>Vezetéknév: </td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>Keresztnév: </td>
        <td>${lastName}</td>
    </tr>
    <tr>
        <td>E-mail cím: </td>
        <td>${email}</td>
    </tr>
</table>
</body>

</html>
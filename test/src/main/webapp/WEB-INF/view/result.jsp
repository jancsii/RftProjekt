<%@page contentType = "text/html;charset = iso-8859-2" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>asd</title>
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
        <a class="active" href="result">Kezdolap</a>
        <a href="players">Jatek</a>
        <a href="myteam">Csapatom</a>
        <a href="enemy">Ellenfel</a>
        <a href="piac">Piac</a>
        <a href="logout">Kilepes</a>
        <div class="nav navbar-right">
            <a href="registration"><span class="glyphicon glyphicon-user "></span> Sign Up</a>
            <a href="login"><span class="glyphicon glyphicon-log-in "></span> Login</a>
        </div>
    </div>
<h2>A felhasznal� adatai</h2>
<h3></h3>
<table>
    <tr>
        <td>Felhaszn�n�v: </td>
        <td>${username}</td>
    </tr>
    <tr>
        <td>Vezet�kn�v: </td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>Keresztn�v: </td>
        <td>${lastName}</td>
    </tr>
    <tr>
        <td>E-mail c�m: </td>
        <td>${email}</td>
    </tr>
</table>
</body>

</html>
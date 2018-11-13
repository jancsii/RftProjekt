<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ellenfél</title>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link type="text/css" rel="stylesheet" href="/resources/static/css/enemy.css"/>

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
    
<h2>Ellenfel csapat:</h2>

<center>
<div class="wrapper">
<div class="campo">
     <div class="semi1"></div>
     <div class="semi2"></div>
     <div class="divisoria"></div>
     <div class="interior"></div>
     <div class="penalty"></div>   
     
     <div class="gk"><button name="kapus"  class="btn btn-danger" type="submit" value='${listEnemyTeam[0]}'>${listEnemyTeam[0]}</button></div>
     <div class="cb"><button name="vedo_1"  class="btn btn-danger" type="submit" value='${listEnemyTeam[1]}'>${listEnemyTeam[1]}</button></div>
     <div class="lwb"><button name="vedo_2"  class="btn btn-danger" type="submit" value='${listEnemyTeam[2]}'>${listEnemyTeam[2]}</button></div>
     <div class="lb"><button name="vedo_3"  class="btn btn-danger" type="submit" value='${listEnemyTeam[3]}'>${listEnemyTeam[3]}</button></div>
     <div class="rb"><button name="vedo_4"  class="btn btn-danger" type="submit" value='${listEnemyTeam[4]}'>${listEnemyTeam[4]}</button></div>
     <div class="dm"><button name="kozep_1"  class="btn btn-danger" type="submit" value='${listEnemyTeam[5]}'>${listEnemyTeam[5]}</button></div>
     <div class="lm"><button name="kozep_2"  class="btn btn-danger" type="submit" value='${listEnemyTeam[6]}'>${listEnemyTeam[6]}</button></div>
     <div class="cm"><button name="kozep_3"  class="btn btn-danger" type="submit" value='${listEnemyTeam[7]}'>${listEnemyTeam[7]}</button></div>
     <div class="rm"><button name="kozep_4"  class="btn btn-danger" type="submit" value='${listEnemyTeam[8]}'>${listEnemyTeam[8]}</button></div>
     <div class="wl"><button name="tamado_1" class="btn btn-danger" type="submit" value='${listEnemyTeam[9]}'>${listEnemyTeam[9]}</button></div>
     <div class="st"><button name="tamado_2" class="btn btn-danger" type="submit" value='${listEnemyTeam[10]}'>${listEnemyTeam[10]}</button></div>
  </div>
 </div>
</center>

</body>
</html>


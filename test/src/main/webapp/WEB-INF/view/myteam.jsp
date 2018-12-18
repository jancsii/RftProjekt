<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Csapataim</title>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/static/css/myteam.css"/>

    </head>

    <body>
        <div class="topnav">
        <a href="result">Adataim</a>
        <a class="active" href="myteam">Saját csapatom</a>
        <a href="piac">Átigazolási piac</a>
        <a href="players">Játék</a>
        <div class="nav navbar-right">
            <a href="logout"><span class="glyphicon glyphicon-log-out"></span> Kilépés</a>
        </div>
    </div>
    
<h2>Csapataim</h2>
<h3>Ezen az oldalon tudod változtani a felállásaidat két meccs között. Az alábbi három csapat áll rendelkezésre
3 különböző taktikával, amelyek bizonyos ellenfelek esetén hasznosak lehetnek. Igazolni az átigazolási piacon tudsz.
</h3>
<h4>Vigyázz! Figyelj milyen taktikát választassz ki, mert az átigazolási piacon vett játékosod, abba a csapatba fog bekerülni automatikusan.</h4>

<center>
    <h5>4-3-3</h5>
<div class="wrapper">
<div class="campo">
     <div class="semi1"></div>
     <div class="semi2"></div>
     <div class="divisoria"></div>
     <div class="interior"></div>
     <div class="penalty"></div>        
     <div class="gk"><button name="kapus"  class="btn btn-success" type="submit" value='${listMyTeam[0]}'>${listMyTeam[0]}</button></div>
     <div class="cb"><button name="vedo_1"  class="btn btn-success" type="submit" value='${listMyTeam[1]}'>${listMyTeam[1]}</button></div>
     <div class="lwb"><button name="vedo_2"  class="btn btn-success" type="submit" value='${listMyTeam[2]}'>${listMyTeam[2]}</button></div>
     <div class="lb"><button name="vedo_3"  class="btn btn-success" type="submit" value='${listMyTeam[3]}'>${listMyTeam[3]}</button></div>
     <div class="rb"><button name="vedo_4"  class="btn btn-success" type="submit" value='${listMyTeam[4]}'>${listMyTeam[4]}</button></div>
     <div class="dma"><button name="kozep_a1"  class="btn btn-success" type="submit" value='${listMyTeam[5]}'>${listMyTeam[5]}</button></div>
     <div class="lma"><button name="kozep_a2"  class="btn btn-success" type="submit" value='${listMyTeam[6]}'>${listMyTeam[6]}</button></div>
     <div class="cma"><button name="kozep_a3"  class="btn btn-success" type="submit" value='${listMyTeam[7]}'>${listMyTeam[7]}</button></div>
     <div class="rma"><button name="tamado_a1"  class="btn btn-success" type="submit" value='${listMyTeam[8]}'>${listMyTeam[8]}</button></div>
     <div class="wla"><button name="tamado_a2" class="btn btn-success" type="submit" value='${listMyTeam[9]}'>${listMyTeam[9]}</button></div>
     <div class="sta"><button name="tamado_a3" class="btn btn-success" type="submit" value='${listMyTeam[10]}'>${listMyTeam[10]}</button></div>
  </div>
 </div>
</center>
    <center>
        <h5>4-4-2</h5>
<div class="wrapper">
<div class="campo">
     <div class="semi1"></div>
     <div class="semi2"></div>
     <div class="divisoria"></div>
     <div class="interior"></div>
     <div class="penalty"></div>   
     <div class="gk"><button name="kapus"  class="btn btn-success" type="submit" value='${listMyTeam2[0]}'>${listMyTeam2[0]}</button></div>
     <div class="cb"><button name="vedo_1"  class="btn btn-success" type="submit" value='${listMyTeam2[1]}'>${listMyTeam2[1]}</button></div>
     <div class="lwb"><button name="vedo_2"  class="btn btn-success" type="submit" value='${listMyTeam2[2]}'>${listMyTeam2[2]}</button></div>
     <div class="lb"><button name="vedo_3"  class="btn btn-success" type="submit" value='${listMyTeam2[3]}'>${listMyTeam2[3]}</button></div>
     <div class="rb"><button name="vedo_4"  class="btn btn-success" type="submit" value='${listMyTeam2[4]}'>${listMyTeam2[4]}</button></div>
     <div class="dm"><button name="kozep_1"  class="btn btn-success" type="submit" value='${listMyTeam2[5]}'>${listMyTeam2[5]}</button></div>
     <div class="lm"><button name="kozep_2"  class="btn btn-success" type="submit" value='${listMyTeam2[6]}'>${listMyTeam2[6]}</button></div>
     <div class="cm"><button name="kozep_3"  class="btn btn-success" type="submit" value='${listMyTeam2[7]}'>${listMyTeam2[7]}</button></div>
     <div class="rm"><button name="kozep_4"  class="btn btn-success" type="submit" value='${listMyTeam2[8]}'>${listMyTeam2[8]}</button></div>
     <div class="wl"><button name="tamado_1" class="btn btn-success" type="submit" value='${listMyTeam2[9]}'>${listMyTeam2[9]}</button></div>
     <div class="st"><button name="tamado_2" class="btn btn-success" type="submit" value='${listMyTeam2[10]}'>${listMyTeam2[10]}</button></div>
  </div>
 </div>
</center>
    <center>
        <h5>3-5-2</h5>
<div class="wrapper">
<div class="campo">
     <div class="semi1"></div>
     <div class="semi2"></div>
     <div class="divisoria"></div>
     <div class="interior"></div>
     <div class="penalty"></div>
     <div class="gk"><button name="kapus"  class="btn btn-success" type="submit" value='${listMyTeam3[0]}'>${listMyTeam3[0]}</button></div>
     <div class="cbc"><button name="vedo_c1"  class="btn btn-success" type="submit" value='${listMyTeam3[1]}'>${listMyTeam3[1]}</button></div>
     <div class="lwbc"><button name="vedo_c2"  class="btn btn-success" type="submit" value='${listMyTeam3[2]}'>${listMyTeam3[2]}</button></div>
     <div class="lbc"><button name="vedo_c3"  class="btn btn-success" type="submit" value='${listMyTeam3[3]}'>${listMyTeam3[3]}</button></div>
     <div class="rbc"><button name="kozep_c1"  class="btn btn-success" type="submit" value='${listMyTeam3[4]}'>${listMyTeam3[4]}</button></div>
     <div class="dmc"><button name="kozep_c2"  class="btn btn-success" type="submit" value='${listMyTeam3[5]}'>${listMyTeam3[5]}</button></div>
     <div class="lmc"><button name="kozep_c3"  class="btn btn-success" type="submit" value='${listMyTeam3[6]}'>${listMyTeam3[6]}</button></div>
     <div class="cmc"><button name="kozep_c4"  class="btn btn-success" type="submit" value='${listMyTeam3[7]}'>${listMyTeam3[7]}</button></div>
     <div class="rmc"><button name="kozep_c5"  class="btn btn-success" type="submit" value='${listMyTeam3[8]}'>${listMyTeam3[8]}</button></div>
     <div class="wl"><button name="tamado_1" class="btn btn-success" type="submit" value='${listMyTeam3[9]}'>${listMyTeam3[9]}</button></div>
     <div class="st"><button name="tamado_2" class="btn btn-success" type="submit" value='${listMyTeam3[10]}'>${listMyTeam3[10]}</button></div>
  </div>
 </div>
</center>
<form action="/myteam" method="post">
            <select name="valaszt" class="selectpicker" data-style="btn-new">
                <option value="tamado">4-3-3</option>
                <option selected="selected" value="alap">4-4-2</option>
                <option value="kozepes">3-5-2</option>
            </select>
        <button type="submit" class="btn btn-dark btn-rounded btn-primary center-block">Mentés</button>
    </form>
</body>
</html>


</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Csapat</title>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link type="text/css" rel="stylesheet" href="/resources/static/css/players.css"/>
        <style>
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-repeat:initial;
    background-image: url("https://www.premiumwhistler.com/wp-content/uploads/2016/10/wallpaper-background-black-widescreen-windows-dekstop-barcelona-messi-argentina-football-screensaver-lionel-graphics-creative-abstract-images-backgrounds.jpg"); 
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>
<script>
$(document).ready(function(){
    $("h4").hide();
    $("h5").hide();
    $("h6").hide();
    $(".ClassNameOfShouldBeHiddenElements").hide();
    $("h3").click(function(){
        $("h4").css("color", "red");
        $("h4").css( "fontSize", "50px" );
        $("h4").show();
        $("h4").css("text-align", "center");
        $("h5").css("text-align", "center");
        $("h5").show();
        $("h6").css("color", "yellow");
        $("h6").css( "fontSize", "25px" );
        $("h6").css("text-align", "center");
        $("h6").show();
    });
});
</script>

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
    <h1><c:out value="${szint}" /></h1>
    <h1><c:out value="${probalkozas}" /></h1>
    <h2>Saját csapatod </h2>
<center>
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
     <div class="dm"><button name="kozep_1"  class="btn btn-success" type="submit" value='${listMyTeam[5]}'>${listMyTeam[5]}</button></div>
     <div class="lm"><button name="kozep_2"  class="btn btn-success" type="submit" value='${listMyTeam[6]}'>${listMyTeam[6]}</button></div>
     <div class="cm"><button name="kozep_3"  class="btn btn-success" type="submit" value='${listMyTeam[7]}'>${listMyTeam[7]}</button></div>
     <div class="rm"><button name="kozep_4"  class="btn btn-success" type="submit" value='${listMyTeam[8]}'>${listMyTeam[8]}</button></div>
     <div class="wl"><button name="tamado_1" class="btn btn-success" type="submit" value='${listMyTeam[9]}'>${listMyTeam[9]}</button></div>
     <div class="st"><button name="tamado_2" class="btn btn-success" type="submit" value='${listMyTeam[10]}'>${listMyTeam[10]}</button></div>
  </div>
 </div>
</center>
    <h2>Ellenfél csapata </h2>
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
<h3>
     <button id="myBtn" class="btn btn-info">Eredmény</button>
</h3>
<!-- The Modal -->

<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <h4><c:out value="${result}" /></h4>
            <h5>        
            <form action="/players" method="post">

            <button type="submit" class="btn btn-info">Tovabb</button>
        </form></h5>
  </div>

</div>

<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>   

       <!-- <h6><c:out value="${szint}" /></h6>-->
            <h4><c:out value="${result}" /></h4>
            <h5>        
            <form action="/players" method="post">

            <button type="submit" class="btn btn-info">Tovabb</button>
        </form></h5>
</body>
</html>


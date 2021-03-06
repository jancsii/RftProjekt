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
        <script type="text/javascript" src="/resources/static/js/players.js"></script>

    </head>

    <body>
        <div class="topnav">
            <a href="result">Adataim</a>
            <a href="myteam">Saj�t csapatom</a>
            <a href="piac">�tigazol�si piac</a>
            <a class="active" href="players">J�t�k</a>
            <div class="nav navbar-right">
                <a href="logout"><span class="glyphicon glyphicon-log-out"></span> Kil�p�s</a>
            </div>
        </div>



        <h2>Ellenf�l csapata </h2>

        <div class="wrapper">
            <div class="campo">
                <div class="semi1"></div>
                <div class="semi2"></div>
                <div class="divisoria"></div>
                <div class="interior"></div>
                <div class="penalty"></div>   
                <div class="gk"><button name="kapus"  style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[0]}'>${listEnemyTeam[0]}</button></div>
                <div class="cb"><button name="vedo_1"  style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[1]}'>${listEnemyTeam[1]}</button></div>
                <div class="lwb"><button name="vedo_2"  style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[2]}'>${listEnemyTeam[2]}</button></div>
                <div class="lb"><button name="vedo_3"  style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[3]}'>${listEnemyTeam[3]}</button></div>
                <div class="rb"><button name="vedo_4"  style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[4]}'>${listEnemyTeam[4]}</button></div>
                <div class="dm"><button name="kozep_1"  style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[5]}'>${listEnemyTeam[5]}</button></div>
                <div class="lm"><button name="kozep_2"  style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[6]}'>${listEnemyTeam[6]}</button></div>
                <div class="cm"><button name="kozep_3"  style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[7]}'>${listEnemyTeam[7]}</button></div>
                <div class="rm"><button name="kozep_4"  style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[8]}'>${listEnemyTeam[8]}</button></div>
                <div class="wl"><button name="tamado_1" style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[9]}'>${listEnemyTeam[9]}</button></div>
                <div class="st"><button name="tamado_2" style="vertical-align: middle;" class="btn btn-danger" type="submit" value='${listEnemyTeam[10]}'>${listEnemyTeam[10]}</button></div>
            </div>
        </div>
        <div class="container">
            <table >
                <tbody>
                    <tr>
                        <td>Jelenlegi szinted:</td>
                        <td><c:out value="${szint}" /></td>
                    </tr>
                    <tr>
                        <td>Pr�b�lkoz�said sz�ma:</td>
                        <td><c:out value="${probalkozas}" /></td>
                    </tr>        
                </tbody>
            </table>
        </div>            
        <h3>
            <button id="myBtn" class="btn btn-info">Eredm�ny</button>
        </h3>
        <!-- The Modal -->

        <div id="myModal" class="modal">

            <!-- Modal content -->
            <div class="modal-content">
                <span class="close">&times;</span>                
                <h4><c:out value="${res}" /></h4>
                <h4><c:out value="${result}" /></h4>
                <h5>        
                    <form action="/players" method="post">

                        <button type="submit" class="btn btn-info">Tov�bb</button>
                    </form></h5>
            </div>

        </div>
        <script type="text/javascript" src="/resources/static/js/players2.js"></script>
    </body>
</html>
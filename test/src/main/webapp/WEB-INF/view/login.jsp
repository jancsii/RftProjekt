<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bejelentkezés</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link type="text/css" rel="stylesheet" href="/resources/static/css/login.css"/>	
    </head>
    <body>
        
          <form:form name="submitForm" method="POST" class="form-signin" >
            <div class="topnav">
                <a href=""><span class="glyphicon glyphicon-home "></span> Kezdőlap</a>
                <div class="nav navbar-right">
                    <a href="registration"><span class="glyphicon glyphicon-user "></span> Regisztráció</a>
                    <a class="active" href="login"><span class="glyphicon glyphicon-log-in "></span> Bejelentkezés</a>
                </div>
            </div>
            <table>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                 <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
		<h3>Bejelentkezés</h3>
            </div>
            <div class="card-body">
            <table style="text-align:center;">
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><div class="input-group-prepend">
			<span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div></td>
                    <td><input type="text" name="userName" placeholder="Enter Username" required ></td>
                </tr>
                
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
			</div></td>
                    <td><input type="password" name="password" placeholder="Enter Password" required ></td>
                </tr>       
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                 </table>
                <label>${error}</label>
                <input type="submit" value="Bejelentkezés" class="login_btn center-block" style="border-radius: 12px;">
            </div>
            <div class="d-flex justify-content-center links ">                    
                    Nincs még felhasználód?<a href="/registration">Regisztráció</a>
		</div>
        </div>
    </div>
</div>

    <!--       
    <h2>Bejelentkezés</h2>
            <table style="text-align:center;">
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><label class="ertek" for="userName"><b>Felhasználónév: </b></label></td>
                    <td><input type="text" name="userName" placeholder="Enter Username" required ></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><label class="ertek" for="password"><b>Jelszó: </b></label></td>
                    <td><input type="password" name="password" placeholder="Enter Password" required ></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
        </table>
    <div style="text-align:center;">
        <button type="submit" class="btn btn-dark btn-rounded">Login</button>
    </div>
            <div class="hiba" style="color: red">${error}</div>
    </form:form>-->
    </body>
</html>
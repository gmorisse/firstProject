<%-- 
    Document   : index
    Created on : 17 juin 2021, 10:13:06
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My First Page</title>
                <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">

        <link rel="stylesheet"

            href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css"

            integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    </head>
    <body>
        <h2 class="center titre-perso my-font-family mt-4"><img src="Images/1200px-Circle-icons-dev.svg.png" width="5%" />DEV-3-2021</h2>
        
        <h3 class="text-center titre-perso mt-4">Connexion</h3>
        
        <div class="container mt-4">
            <form action="ConnexionServlet" method="POST">
                <div style="margin: auto; width: 40%">
                    <div class="form-group">
                        <label class="label-perso">Login : </label>
                        <input type="text" name="login" value="${param['login']}" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label class="label-perso">Password : </label>
                        <input type="password" name="pwd" class="form-control" />
                    </div>
                    <button type="submit" class="btn btn-block btn-primary">Connexion</button>
                    <button type="button" onclick="window.location.href='InscriptionServlet'" class="btn btn-block btn-primary">S'inscrire ?</button>
                    <br/>
                    <div>
                        <p class="color-red">${msg}</p>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>

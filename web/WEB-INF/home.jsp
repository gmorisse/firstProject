<%-- 
    Document   : home
    Created on : 17 juin 2021, 14:30:07
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">

        <link rel="stylesheet"

              href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css"

              integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="menu.jsp" %>  

        <div class="container mt-4">
            <h1 class="titre-perso center">Mon espace privé</h1>
            <br/>

            <div>
                <div class="row">
                    <c:forEach var="n" items="${memoPrive}">
                        <div class="row">
                            <div class="card my-font-family p-4">
                                <div class="col-sm-10">

                                    <div>
                                        <p class="label-perso"> Date : ${n.dateCreation}</p>
                                        <p class="label-perso"> ${n.contenu} </p>
                                    </div>
                                    <div class="col-sm-2">
                                        <c:choose>
                                            <c:when test=" ${n.prive == true}">prive</c:when>
                                            <c:otherwise>public</c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
    </body>
</html>

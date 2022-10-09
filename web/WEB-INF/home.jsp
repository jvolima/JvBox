<%-- 
    Document   : home
    Created on : 06/10/2022, 18:43:09
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home | JvBox</title>
        <meta charset="UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="./styles/home.css"/>
        <link rel="stylesheet" href="./styles/global.css" />
    </head>
    <body>
        <tags:header />
        
        <main id="container">
            <div id="imagesList">
                <c:forEach var="image" varStatus="status" items="${images}">
                    <a class="imageCard" href="ImageController?id=${image.id}">
                        <img src="DisplayImageController?id=${image.id}" alt="" />
                        <div>
                            <h3>${image.name}</h3>
                            <span>${image.description}</span>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </main>
    </body>
</html>

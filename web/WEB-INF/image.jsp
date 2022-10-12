<%-- 
    Document   : image
    Created on : 09/10/2022, 20:09:13
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Imagem | JvBox</title>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Itim&family=Roboto:wght@400;700&display=swap" rel="stylesheet" />
        <script src="https://unpkg.com/phosphor-icons"></script>
        <link rel="stylesheet" href="./styles/global.css"/>
        <link rel="stylesheet" href="./styles/image.css"/>
    </head>
    <body> 
        <div id="container">
            <header>
                <div id="backContainer">
                    <a href="HomeController">
                        <i class="ph-caret-left-bold"></i>
                    </a>
                    <div>
                        <span>Voltar</span>
                    </div>
                </div>
                <div id="imageActions">
                    <a id="delete" href="DeleteImageController?id=${image.id}">
                        Apagar
                        <i class="ph-trash-fill"></i>
                    </a>
                    <a id="update" href="UpdateImageController?id=${image.id}">
                        Editar
                        <i class="ph-pencil-fill"></i>
                    </a>
                </div>
            </header>
            
            <div id="imageContent">
                <h1>${image.name}</h1>
                <span>${image.description}</span>
                <img src="DisplayImageController?id=${image.id}" alt="" />
                
            </div>
        </div>
    </body>
</html>

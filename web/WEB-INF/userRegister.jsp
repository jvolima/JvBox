<%-- 
    Document   : userRegister
    Created on : 06/10/2022, 09:54:46
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Usuário | JvBox</title>
        <meta charset="UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Itim&family=Roboto:wght@400;700&display=swap" rel="stylesheet" />
        <script src="https://unpkg.com/phosphor-icons"></script>
        <link rel="stylesheet" href="./styles/global.css" />
        <link rel="stylesheet" href="./styles/userRegister.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="container">
            <header>
                <a href="LoginController">
                    <i class="ph-caret-left-bold"></i>
                </a>
                <div>
                    <span>Voltar</span>
                </div>
            </header>   
            
            <form method="post" action="UserRegisterController">
                <div id="formLabel">
                    <h2>Cadastro</h2>
                </div>
                <div id="inputList">
                    <div class="containerInput">
                        <label for="name">Nome</label>
                        <input type="text" name="name" id="name" />
                    </div>
                    
                    <div class="containerInput">
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email" />
                    </div>
                    
                    <div class="containerInput">
                        <label for="password">Senha</label>
                        <input type="password" name="password" id="password" />
                    </div>
                </div>
                
                <div id="containerButton">
                    <button type="submit">Cadastrar</button>
                </div>
            </form>
            
            <footer>
                <img src="https://imagensemoldes.com.br/wp-content/uploads/2020/05/Goku-Concentrado-PNG-811x1024.png" />
            </footer>
        </div>
    </body>
</html>

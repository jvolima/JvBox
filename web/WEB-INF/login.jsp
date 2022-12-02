<%-- 
    Document   : login
    Created on : 04/10/2022, 18:08:44
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login | JvBox</title>
        <meta charset="UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="./styles/global.css" />
        <link rel="stylesheet" href="./styles/login.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="container">
            <div id="containerLeft">
                <div id="name">
                    <h1>Jv<span>Box</span></h1>
                    <img src="https://i.pinimg.com/originals/a5/f9/a2/a5f9a2eb5c0bfb1f66988696e1f31334.png" />
                </div>
                <form onsubmit="logar(event)">
                    <div>
                        <input type="email" name="email" id="email" placeholder="Email" />
                        <input type="password" name="password" id="password" placeholder="Senha" />
                    </div>
                        
                    <button type="submit">
                        Entrar
                    </button>
                </form>
                
                <a id="registerLink" href="UserRegisterController">
                    Realizar cadastro
                </a>
            </div>
            <div id="containerRight">
                <img src="./images/goku.png" alt="" />
            </div>
        </div>
    </body>
    
    <script>
        async function logar(event) {
            event.preventDefault();

            let data = new FormData(event.target);

            let resultado = await fetch('LoginController', {
                method: 'post',
                body: data
            });
            
            let resultadoData = await resultado.json();
            
            if(!resultadoData.status){
               location.href = "HomeController";
            }
            else {
                alert(resultadoData.Message);
            }
        }
    </script>
</html>

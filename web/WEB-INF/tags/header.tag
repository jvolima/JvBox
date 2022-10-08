<%-- 
    Document   : header
    Created on : 07/10/2022, 09:53:39
    Author     : jvolima
--%>

<%@tag description="Header" pageEncoding="UTF-8"%>

<%-- any content can be specified here e.g.: --%>
<head>
    <link rel="stylesheet" href="./styles/header.css"/>
    <script src="https://unpkg.com/phosphor-icons"></script>
</head>

<html>
    <head>
        <title>title</title>
    </head>
    <body>
        <header>    
            <div id="headerContent">
                <div id="logo">
                    <h2>Jv<span>Box</span></h2>
                    <img src="https://i.pinimg.com/originals/a5/f9/a2/a5f9a2eb5c0bfb1f66988696e1f31334.png" />
                </div>
                <button onclick="handleOpenModal()">
                    Adicionar imagem
                </button>
            </div>
        </header>

        <dialog id="modal">
            <div>
                <h1>Hello world</h1>
                <button onclick="handleCloseModal()">
                    <i class="ph-x"></i>
                </button>
            </div>
        </dialog>
    </body>
    
    <script>
        function handleOpenModal() {
            let dialog = document.getElementById("modal");
            dialog.showModal();
        }

        function handleCloseModal() {
            let dialog = document.getElementById("modal");
            dialog.close();
        }
    </script>
</html>

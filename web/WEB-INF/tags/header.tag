<%-- 
    Document   : header
    Created on : 07/10/2022, 09:53:39
    Author     : jvolima
--%>

<%@tag description="Header" pageEncoding="UTF-8"%>

<%-- any content can be specified here e.g.: --%>

<html>
    <head>
        <link rel="stylesheet" href="./styles/header.css"/>
        <link rel="stylesheet" href="./styles/modal.css"/>
        <script src="https://unpkg.com/phosphor-icons"></script>
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
            <div id="modalHeader">
                <h1>Nova imagem</h1>
                <button onclick="handleCloseModal()">
                    <i class="ph-x"></i>
                </button>
            </div>
            
            <form method="post" action="AddImageController" enctype="multipart/form-data">
                <label for="uploadInput">
                    <i class="ph-plus"></i>
                    Adicione sua imagem
                </label>
                <input type="file" name="image" id="uploadInput" />
                <input type="text" placeholder="Título da imagem..." name="name" class="inputs" />
                <input type="text" placeholder="Descrição da imagem..." name="description" class="inputs" />
                
                <button type="submit">
                    Enviar
                </button>
            </form>
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

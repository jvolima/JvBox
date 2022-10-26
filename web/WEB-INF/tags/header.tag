<%-- 
    Document   : header
    Created on : 07/10/2022, 09:53:39
    Author     : jvolima
--%>

<%@tag description="Header" pageEncoding="UTF-8"%>

<%-- any content can be specified here e.g.: --%>

<html>
    <head>
        <link rel="stylesheet" href="styles/header.css"/>
        <link rel="stylesheet" href="./styles/modal.css"/>
        <script src="https://unpkg.com/phosphor-icons"></script>
    </head>
    <script>
        var loadFile = function(event) {
          var output = document.getElementById("output");
          output.src = URL.createObjectURL(event.target.files[0]);
          output.onload = function() {
            URL.revokeObjectURL(output.src) // free memory
          }
          
          imageThumb();
        };
        
        function imageThumb() {
            var input = document.getElementById("uploadInput");
            var output = document.getElementById("output");
            var content = document.getElementById("uploadInputContent");
            var outputText = document.getElementById("outputText");
            
            if (input.value === "") {
                outputText.style="display:none";
                output.style="display:none";
            } else {
                content.style="display:none";
                outputText.style="display:block";
                output.style="display:block";
            }
        }
        
        function handleOpenModal() {
            let dialog = document.getElementById("modal");
            dialog.showModal();
        }

        function handleCloseModal() {
            let dialog = document.getElementById("modal");
            dialog.close();
        }
    </script>
    <body onload="imageThumb()">
        <header>    
            <div id="headerContent">
                <div id="logo">
                    <h2>Jv<span>Box</span></h2>
                    <img src="https://i.pinimg.com/originals/a5/f9/a2/a5f9a2eb5c0bfb1f66988696e1f31334.png" />
                </div>
                <div id="actions">
                    <button onclick="handleOpenModal()">
                        Adicionar imagem
                    </button>
                    
                    <a href="LogoutController">
                        Sair
                        <i class="ph-sign-out"></i>
                    </a>
                </div>
            </div>
        </header>

        <dialog id="modal">
            <div id="modalHeader">
                <h1>Nova imagem</h1>
                <button onclick="handleCloseModal()">
                    <i class="ph-x"></i>
                </button>
            </div>
            
            <form method="post" action="AddImageController" enctype="multipart/form-data" onchange="loadFile(event)" > 
                <label for="uploadInput">
                    <div id="uploadInputContent">
                        <i class="ph-plus"></i>
                        Adicione sua imagem
                    </div>
                    
                    <img id="output" alt="" />
                    
                    <span id="outputText">Alterar a imagem</span>
                </label>
                
                <input type="file" name="image" id="uploadInput" />
                <input type="text" placeholder="Título da imagem..." name="name" class="inputs" required />
                <input type="text" placeholder="Descrição da imagem..." name="description" class="inputs" required />
                
                <button type="submit">
                    Enviar
                </button>
            </form>
        </dialog>
    </body>
</html>

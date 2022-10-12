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
        <link rel="stylesheet" href="./styles/modal.css"/>
    </head>
    <body> 
        <script>
            var loadFile = function(event) {
                var output = document.getElementById("output");
                output.src = URL.createObjectURL(event.target.files[0]);
                output.onload = function() {
                  URL.revokeObjectURL(output.src) // free memory
                }

                imageThumb();
            };
        
            function handleOpenModal() {         
                let dialog = document.getElementById("modal");
                dialog.showModal();
            }

            function handleCloseModal() {
                let dialog = document.getElementById("modal");
                dialog.close();
            }
        </script>
        
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
                    <a id="update" onclick="handleOpenModal()">
                        Editar
                        <i class="ph-pencil-fill"></i>
                    </a>
                </div>
            </header>
                        
            <dialog id="modal">
                <div id="modalHeader">
                    <h1>Alterar imagem</h1>
                    <button onclick="handleCloseModal()">
                        <i class="ph-x"></i>
                    </button>
                </div>
                
                <form method="post" action="UpdateImageController" enctype="multipart/form-data" onchange="loadFile(event)" > 
                    <label for="uploadInput">               
                        <img id="output" src="DisplayImageController?id=${image.id}" alt="" />

                        <span id="outputText">Alterar a imagem</span>
                    </label>
                
                    <input type="file" name="image" id="uploadInput" />
                    
                    <input type="hidden" name="id" value="${image.id}" />
                    
                    <input 
                        type="text" 
                        value="${image.name}" 
                        placeholder="Título da imagem..." 
                        name="name" 
                        class="inputs" 
                        required
                    />
                    <input 
                        type="text" 
                        value="${image.description}" 
                        placeholder="Descrição da imagem..." 
                        name="description" 
                        class="inputs" 
                        required
                    />
                
                    <button type="submit">
                        Alterar
                    </button>
                </form>
            </dialog>
            
            <div id="imageContent">
                <h1>${image.name}</h1>
                <span>${image.description}</span>
                <img src="DisplayImageController?id=${image.id}" alt="" />      
            </div>
        </div>
    </body>
</html>

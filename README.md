# JvBox

## Tabelas

 Users

- id
- name
- email
- password

Images

- id
- name
- description
- image_content
- image_type
- user_id

```bash
CREATE TABLE Users (
id INT NOT NULL PRIMARY KEY GENERATED ALWAYS
AS IDENTITY (START WITH 1, increment by 1),
name varchar(200) NOT NULL,
email varchar(200) NOT NULL,
password varchar(200) NOT NULL
);

CREATE TABLE Images (
id INT NOT NULL PRIMARY KEY GENERATED ALWAYS
AS IDENTITY (START WITH 1, increment by 1),
name varchar(200) NOT NULL,
description varchar(200) NOT NULL,
image_type varchar(200) NOT NULL,
image_content blob not null,
id_user int NOT NULL,
CONSTRAINT fk_Images_Users FOREIGN KEY (id_user) REFERENCES Users(id)
);
```

## Funcionalidades

- Cadastrar usuário
- Login
- Upload de imagens
- Mostrar imagens do usuário

## Requisitos

- Filters
- Tag Libs
- MVC
- Upload e Reprodução de imagens
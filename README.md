<h1 align="center"> CRUD de Clientes em JAVA </h1>

<p align="center">
  <a href="#exemplo-prático-de-crud-em-java">Exemplo Prático</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#estrutura-do-projeto">Estrutura Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#banco-de-dados">Banco de Dados</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#compilar-e-executar">Compilar e Executar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#interface">Interface</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-o-projeto">O Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-feito-por">Feito por</a>
</p>
<br>

<a href="https://github.com/Ncgrande">
  <img align="center" src="https://img.shields.io/static/v1?label=github&message=NilsonGrande&color=7159c1&style=for-the-badge&logo=ghost"/>
</a>

---

# 🍵 Exemplo prático de CRUD em JAVA

<p align="justify">Este projeto apresenta um exemplo prático de uma aplicação CRUD (Create, Read, Update, Delete) em Java, utilizando interface gráfica, conexão com banco de dados MySQL e boas práticas de orientação a objetos.</p>

---

## 📋 Estrutura do Projeto

O projeto está organizado na seguinte estrutura:
```
projeto-crud-java/
├── crud-db.sql                         # Script SQL para criação do banco de dados
├── lib/
│ └── mysql-connector-j-9.3.0.jar       # Driver JDBC para conexão com MySQL
├── src/
│ ├── Main.java                         # Classe principal
│ ├── dao/
│ │ └── ClienteDAO.java                 # Acesso aos dados (Data Access Object)
│ ├── model/
│ │ └── Cliente.java                    # Classe de modelo (entidade Cliente)
│ ├── util/
│ │ └── Conexao.java                    # Classe utilitária de conexão com o banco
│ └── view/
│ └── ClienteForm.java                  # Interface gráfica (formulário)
```

---


## ❇️ Banco de Dados

Crie o banco e tabela com:

CREATE DATABASE crud_db;
USE crud_db;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100)
);

---


## ✴️ Compilar e Executar

Compile com:

    javac -cp . src/**/*.java

Execute com:

    java -cp src Main

Certifique-se de que o driver JDBC do MySQL está no classpath (mysql-connector-java-X.X.X.jar).

---


## 📌 Interface

A interface gráfica foi desenvolvida com `Swing` e conta com os seguintes elementos:

- Campos para nome, e-mail e telefone (JTextField)
- Botões para Cadastrar, Atualizar, Remover e Listar Clientes (JButton)
- Tabela para exibição dos dados (JTable)
- Mensagens de retorno (JOptionPane)

---


## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- JAVA 
- Swing
- JDBC (MySQL Connector)
- MySQL
- VS Code
- GitHub

---


## 💻 O Projeto

<p align="justify">O objetivo do projeto é servir como exemplo didático de uma aplicação CRUD completa em Java. Ele inclui operações de inserção, consulta, atualização e exclusão de registros de clientes em um banco de dados MySQL, com interface gráfica para facilitar a interação do usuário.</p>

---


## 👽 Feito por

Estudante do 3º semestre de Análise e Desenvolvimento de Sistemas:

- Nilson Grande

## 📚 Sistema de Biblioteca em Java

### 🧠 Sobre o projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais de Java, como:

* Programação Orientada a Objetos (POO)
* Encapsulamento
* Organização em camadas (`model`, `service`, `main`, `persistence`)
* Manipulação de listas com `ArrayList`
* Tratamento de exceções (`try/catch/throw`)
* Persistência de dados em arquivos `.txt`
* Versionamento com Git e GitHub

---

### ⚙️ Funcionalidades

* Cadastro de livros
* Cadastro de usuários
* Empréstimo de livros
* Devolução de livros
* Listagem de livros
* Listagem de usuários
* Controle de disponibilidade dos livros
* Busca de livros por título
* Busca de usuários por e-mail
* Persistência de dados (livros, usuários e empréstimos)

---

### 🏗️ Estrutura do projeto

```
src/
├── main/
│   └── ProjetoBiblioteca.java
│
├── model/
│   ├── Livro.java
│   ├── Usuario.java
│   └── Emprestimo.java
│
├── service/
│   └── Biblioteca.java
│
└── persistence/
    └── GerenciaArquivo.java
```

---

### 💾 Persistência de Dados

O sistema realiza a leitura e escrita de dados em arquivos `.txt`, garantindo que as informações não sejam perdidas ao encerrar o programa.

Arquivos utilizados:

* `livros.txt`
* `usuarios.txt`
* `emprestimos.txt`

---

### 🛠️ Tecnologias utilizadas

* Java
* Git
* GitHub

---

### 🎯 Objetivo

Este projeto faz parte da minha evolução como desenvolvedor, com foco em:

* Aplicar boas práticas de programação
* Construir sistemas completos do zero
* Desenvolver lógica e organização de código
* Trabalhar com persistência de dados
* Me desenvolver como um futuro desenvolvedor backend

---

### 🚀 Melhorias futuras

* Interface gráfica (Swing ou JavaFX)
* Melhorias na busca (uso de `Map`)


---

### 👨‍💻 Autor

João Vitor

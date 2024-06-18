
## 7º DESAFIO JAVA - Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway![Java](https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/20px-Java_programming_language_logo.svg.png)

Esse é o projeto proposto pelo Bootcamp DIO onde devemos criar uma api que explore o conceito de spring boot, web, banco de dados postgres e h2.

##Diagrama de classes

```mermaid
classDiagram
  class User {
    - id: Long
    - nome: String
    - email: String
    - senha: String
    - cursos: Set<Course>
  }

  class Course {
    - id: Long
    - titulo: String
    - descricao: String
    - preco: BigDecimal
    - usuarios: Set<User>
  }

  User "1" -- "*" Course : inscrito em
```


![Bootcamp](https://media0.giphy.com/media/bGgsc5mWoryfgKBx1u/giphy.gif?cid=6c09b952oir71g9bu0hl81xtn9d5n4ngttlrdffpyz5uzhuc&ep=v1_gifs_search&rid=giphy.gif&ct=g)

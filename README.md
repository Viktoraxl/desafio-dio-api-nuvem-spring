# desafio-dio-api-nuvem-spring

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

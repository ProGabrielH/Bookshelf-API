# Bookshelf API

Bookshelf API é uma aplicação para gerenciamento de livros, permitindo a consulta, adição, edição e remoção de livros em uma "estante virtual". O projeto tem como objetivo praticar o desenvolvimento de uma API REST em Java com Spring Boot.

## Status do Projeto

🚧 Em desenvolvimento 🚧

## Tecnologias Utilizadas

- **Java** (JDK 21+)
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **Banco de Dados** (MySQL)
- **ModelMapper**
- **Maven**

## Endpoints Disponíveis

### Livros (Books)
- `GET /books` - Lista todos os livros
- `GET /books/{id}` - Obtém um livro pelo ID
- `POST /books` - Adiciona um novo livro
- `PUT /books/{id}` - Atualiza um livro existente
- `DELETE /books/{id}` - Remove um livro

### Autores (Authors)
- `GET /authors` - Lista todos os autores
- `GET /authors/{id}` - Obtém um autor pelo ID
- `POST /authors` - Adiciona um novo autor
- `PUT /authors/{id}` - Atualiza um autor existente
- `DELETE /authors/{id}` - Remove um autor

### Categorias (Categories)
- `GET /categories` - Lista todas as categorias
- `GET /categories/{id}` - Obtém uma categoria pelo ID
- `POST /categories` - Adiciona uma nova categoria
- `PUT /categories/{id}` - Atualiza uma categoria existente
- `DELETE /categories/{id}` - Remove uma categoria

## Possíveis Futuras Implementações
- Autenticação e Autorização com JWT
- Implementação de testes automatizados
- Paginação e ordenação de resultados
- Melhorias na documentação da API (Swagger/OpenAPI)

## Contribuição
Se deseja contribuir com este projeto, fique à vontade para abrir uma issue ou enviar um pull request!

## Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.


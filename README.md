# Bookshelf API

Bookshelf API é uma aplicação para gerenciamento de livros, permitindo a consulta, adição, edição e remoção de livros em uma "estante virtual". O projeto tem como objetivo praticar o desenvolvimento de uma API REST em Java com Spring Boot.

## Status do Projeto

✔️ Concluído ✔️

## Tecnologias Utilizadas

- **Java** (JDK 21+)
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **Banco de Dados** (MySQL)
- **ModelMapper**
- **Maven**

## Endpoints Disponíveis

### Livro (Book)
- `GET /book` - Lista todos os livros
- `GET /book/{id}` - Obtém um livro pelo ID
- `POST /book` - Adiciona um novo livro
- `PUT /book` - Atualiza um livro existente
- `DELETE /books/{id}` - Remove um livro

### Autor (Author)
- `GET /author` - Lista todos os autores
- `GET /author/{id}` - Obtém um autor pelo ID
- `POST /author` - Adiciona um novo autor
- `PUT /author` - Atualiza um autor existente
- `DELETE /author/{id}` - Remove um autor

### Categoria (Category)
- `GET /category` - Lista todas as categorias
- `GET /category/{id}` - Obtém uma categoria pelo ID
- `POST /category` - Adiciona uma nova categoria
- `PUT /category` - Atualiza uma categoria existente
- `DELETE /category/{id}` - Remove uma categoria

## Possíveis Futuras Implementações
- Autenticação e Autorização com JWT
- Implementação de testes automatizados
- Paginação e ordenação de resultados
- Melhorias na documentação da API (Swagger/OpenAPI)

## Contribuição
Se deseja contribuir com este projeto, fique à vontade para abrir uma issue ou enviar um pull request!

## Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.


# Projeto de Estudos Aprofundados de Testes Unitários com JUnit

## Descrição
Este projeto tem como objetivo aprofundar os conhecimentos em testes unitários utilizando o framework JUnit. O projeto consiste em uma aplicação simples de gerenciamento de livros, onde são aplicados diversos tipos de testes unitários para garantir a qualidade do código.

## Estrutura do Projeto
O projeto está organizado da seguinte forma:
- `src/main/java/com/jhcs`: Contém o código fonte principal da aplicação.
- `src/test/java/com/jhcs`: Contém os testes unitários da aplicação.

## Tecnologias Utilizadas
- **Java**: Linguagem de programação utilizada.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.
- **JUnit 5**: Framework de testes unitários.

## Dependências
As dependências do projeto estão definidas no arquivo `pom.xml`. As principais dependências são:
- `junit-jupiter`: Para execução dos testes unitários.
- `maven-surefire-plugin`: Para integração dos testes com o Maven.

## Estrutura de Classes
### Código Fonte
- `com.jhcs.bookstore.exception.BookNotFoundException`: Exceção personalizada para quando um livro não é encontrado.
- `com.jhcs.bookstore.model.Book`: Classe que representa um livro.
- `com.jhcs.bookstore.service.BookService`: Classe de serviço que gerencia os livros.

### Testes
- `com.jhcs.assertions`: Contém classes de demonstração de diferentes tipos de asserções do JUnit.
- `com.jhcs.disabled`: Contém testes desabilitados.
- `com.jhcs.displayName`: Contém testes com a anotação `@DisplayName`.
- `com.jhcs.exception`: Contém testes que verificam o lançamento de exceções.
- `com.jhcs.test.annotation`: Contém testes com a anotação `@Test`.
- `com.jhcs.assumptions`: Contém testes que utilizam suposições (`assumptions`).

## Executando os Testes
Para executar os testes, utilize o seguinte comando Maven:
```sh
mvn test
```

## Exemplos de Testes
### Teste de Igualdade
```java
@Test
public void assertEqualsWithNoMessage() {
    BookService bookService = new BookService();
    Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
    bookService.addBook(headFirstJavaBook);
    Book book = bookService.getBookById("1");
    assertEquals("Head First Java", book.getTitle());
}
```

### Teste de Exceção
```java
@Test
public void assertThrowsWithNoMessage() {
    BookService bookService = new BookService();
    assertThrows(BookNotFoundException.class, () -> {
        bookService.getBookByTitle("Head First Spring");
    });
}
```

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## Autor
Jameson Henrique

---

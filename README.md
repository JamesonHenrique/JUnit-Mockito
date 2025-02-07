# Projeto de Estudos Aprofundados de Testes Unitários com JUnit e Mockito

## Descrição
Este projeto tem como objetivo aprofundar os conhecimentos em testes unitários utilizando os frameworks JUnit e Mockito. O projeto consiste em uma aplicação simples de gerenciamento de livros, onde são aplicados diversos tipos de testes unitários para garantir a qualidade do código.

## Estrutura do Projeto
O projeto está organizado da seguinte forma:
- `src/main/java`: Contém o código fonte principal da aplicação.
- `src/test/java`: Contém os testes unitários da aplicação.
- `src/test/resources`: Contém arquivos de recursos para testes.

## Tecnologias Utilizadas
- **Java**: Linguagem de programação utilizada.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.
- **JUnit 5**: Framework de testes unitários.
- **Mockito**: Framework para criação de mocks em testes unitários.

## Dependências
As dependências do projeto estão definidas no arquivo `pom.xml`. As principais dependências são:
- `junit-jupiter`: Para execução dos testes unitários.
- `mockito-junit-jupiter`: Para execução dos testes unitários com Mocks.
- `maven-surefire-plugin`: Para integração dos testes com o Maven.

## Estrutura de Classes
### Código Fonte
- `com.jhcs.bookstore.exception.BookNotFoundException`: Exceção personalizada para quando um livro não é encontrado.
- `com.jhcs.bookstore.model.Book`: Classe que representa um livro.
- `com.jhcs.bookstore.service.BookService`: Classe de serviço que gerencia os livros.
- `com.jhcs.example.Calculator`: Classe de exemplo para cálculos.
- `com.jhcs.example.StringHelper`: Classe de exemplo para manipulação de strings.

### Testes
- `com.jhcs.assertions`: Contém classes de demonstração de diferentes tipos de asserções do JUnit.
- `com.jhcs.disabled`: Contém testes desabilitados.
- `com.jhcs.displayName`: Contém testes com a anotação `@DisplayName`.
- `com.jhcs.exception`: Contém testes que verificam o lançamento de exceções.
- `com.jhcs.test.annotation`: Contém testes com a anotação `@Test`.
- `com.jhcs.assumptions`: Contém testes que utilizam suposições (`assumptions`).
- `com.jhcs.conditional`: Contém testes condicionais baseados no sistema operacional e JRE.
- `com.jhcs.lifecycle`: Contém testes que demonstram o ciclo de vida dos testes.
- `com.jhcs.parameterizedTest`: Contém testes parametrizados.
- `com.jhcs.repeatedTest`: Contém testes repetidos.
- `com.jhcs.dynamicTest`: Contém testes dinâmicos.
- `com.jhcs.mockito.annotations.support`: Contém testes utilizando anotações do Mockito.
- `com.jhcs.mockito.argumentCaptor`: Contém testes utilizando ArgumentCaptor do Mockito.
- `com.jhcs.mockito.argumentMatchers`: Contém testes utilizando ArgumentMatchers do Mockito.
- `com.jhcs.mockito.bdd.behaviorVerification`: Contém testes utilizando BDD com Mockito.
- `com.jhcs.mockito.bdd.stubbing`: Contém testes utilizando stubbing com Mockito.
- `com.jhcs.mockito.behavior.verification`: Contém testes de verificação de comportamento com Mockito.
- `com.jhcs.mockito.exceptionHandling`: Contém testes de tratamento de exceções com Mockito.
- `com.jhcs.mockito.spies`: Contém testes utilizando spies do Mockito.
- `com.jhcs.mockito.stubbing`: Contém testes utilizando stubbing do Mockito.
- `com.jhcs.mockito.testDoubles.dummy`: Contém testes utilizando dummies do Mockito.
- `com.jhcs.mockito.testDoubles.fake`: Contém testes utilizando fakes do Mockito.
- `com.jhcs.mockito.testDoubles.mock`: Contém testes utilizando mocks do Mockito.
- `com.jhcs.mockito.testDoubles.spy`: Contém testes utilizando spies do Mockito.
- `com.jhcs.mockito.testDoubles.stub`: Contém testes utilizando stubs do Mockito.

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
### Teste de Argumentos de Tipo String
```java
    @Test
    public void testStringTypeArgumentMatchers() {
        Book book = new Book("1", "The First In Java", 600, LocalDate.now());
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(contains("First"), anyInt(), anyBoolean())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("The First In Spring", 600, true);
        assertEquals("The First In Java", actualBook.getTitle());
    }
```
## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## Autor
Jameson Henrique

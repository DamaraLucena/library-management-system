<p align="center">
  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=49AA26&labelColor=000000">
</p>

# **Sistema de Gerenciamento de Bibliotecas**

O Sistema de Gerenciamento de Bibliotecas é um aplicativo simples desenvolvido em Java, que permite a criação de usuários, o gerenciamento de empréstimos e devoluções de livros, bem como a pesquisa de livros disponíveis na biblioteca.

## **Funcionalidades**

As funcionalidades do sistema incluem:

- Criação de usuários
- Adição, remoção e pesquisa de livros
- Empréstimo de livros
- Devolução de livros
- Exibição de livros disponíveis na biblioteca

## **Estrutura do Projeto**

O projeto é estruturado em diferentes classes e pacotes, conforme descrito abaixo:

- **Pacote biblioteca**: Contém a classe **`Biblioteca`**, responsável pelo gerenciamento dos livros da biblioteca.
- **Pacote usuarios**: Contém a classe **`Usuario`**, responsável pela criação e gerenciamento dos usuários.
- **Pacote livros**: Contém a classe **`Livro`**, responsável pela criação e gerenciamento dos livros.

## **Classes Principais**

### **Classe Usuario**

A classe **`Usuario`** representa um usuário do sistema de gerenciamento de bibliotecas. Ela possui os seguintes atributos:

- **`nome`**: O nome do usuário.
- **`senha`**: A senha do usuário.
- **`listaLivrosEmprestados`**: Uma lista de livros emprestados pelo usuário.

Além disso, a classe **`Usuario`** possui os seguintes métodos principais:

- **`criarUsuario(nome: String, senha: String)`**: Cria um novo usuário com o nome e senha especificados.
- **`solicitarEmprestimo(livro: Livro)`**: Solicita o empréstimo de um livro, adicionando-o à lista de livros emprestados pelo usuário.
- **`devolverLivro(livro: Livro)`**: Devolve um livro emprestado, removendo-o da lista de livros emprestados pelo usuário.
- **`exibirLivrosEmprestados()`**: Exibe os livros atualmente emprestados pelo usuário.

### **Classe Livro**

A classe **`Livro`** representa um livro na biblioteca. Ela possui os seguintes atributos:

- **`titulo`**: O título do livro.
- **`autor`**: O autor do livro.
- **`disponivel`**: Um indicador de disponibilidade do livro.

A classe **`Livro`** possui os seguintes métodos principais:

- **`criarLivro(titulo: String, autor: String)`**: Cria um novo livro com o título e autor especificados.
- **`alterarStatusDisponibilidade(disponivel: boolean)`**: Altera o status de disponibilidade do livro.
- **`obterInformacoesLivro()`**: Retorna as informações do livro, incluindo título, autor e disponibilidade.

### **Classe Biblioteca**

A classe **`Biblioteca`** representa a biblioteca e o gerenciamento dos livros disponíveis. Ela possui o seguinte atributo:

- **`livros`**: Uma lista de livros na biblioteca.

A classe **`Biblioteca`** possui os seguintes métodos principais:

- **`adicionarLivro(livro: Livro)`**: Adiciona um livro à biblioteca.
- **`removerLivro(livro: Livro)`**: Remove um livro da biblioteca.
- **`pesquisarLivro(titulo: String)`**: Pesquisa um livro na biblioteca pelo título.
- **`exibirLivrosDisponiveis()`**: Exibe os livros disponíveis na biblioteca.

## **Interação com o Usuário**

O sistema oferece uma interface simples de linha de comando para interagir com os usuários. O usuário pode criar um novo usuário, adicionar livros, solicitar empréstimos, devolver livros e realizar outras operações por meio do menu exibido no console.

## **Tecnologias Utilizadas**

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- Java
- java.util.Date


## **Como Executar o Projeto**

1. Clone o repositório para sua máquina local.
2. Certifique-se de ter o JDK (Java Development Kit) instalado em seu sistema.
3. Abra o projeto em sua IDE preferida.
4. Compile o projeto para garantir que não existam erros de compilação.
5. Execute o programa a partir da classe **`Main`**.
6. Siga as instruções exibidas no console para interagir com o sistema de gerenciamento de bibliotecas.

## **Contribuição**

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias, correções de bugs ou novas funcionalidades.

## **Licença**

Este projeto está licenciado sob a **[MIT License](https://chat.openai.com/c/LICENSE)**.

## **Conclusão**

O Sistema de Gerenciamento de Bibliotecas é uma aplicação Java simples, porém funcional, que permite o gerenciamento de usuários, livros e empréstimos em uma biblioteca. Ele oferece uma interface de linha de comando intuitiva para os usuários interagirem com o sistema.

# Everymind-Challenge-Backend
Parte do back-end da aplicação requisitada pelo processo seletivo "Programa Best Minds 2024 - Pessoa Desenvolvedora Trainee". Resolvi dividir o back-end do front-end para deixar as duas aplicações relativamente independentes 
e permitir com que pudessem ser acopladas em outros projetos.

Essa aplicação realiza um CRUD simples, realizando a Criação, Leitura, Atualização e Deleção de produtos para uma loja fictícia denominada Nunes Sports.

O back-end foi feito usando as tecnologias Java, Gradle e Spring. Estou utilizando o H2 como um banco de dados para o perfil de testes, e (pretendo utilizar) o PostgreSQL como SGBD para o perfil de produção.

## Como executar a aplicação

Baixe ou copie o repositório para a sua máquina local, abra-o em uma IDE (Intellij IDEA, STS) ou editor de texto (VSCode) e rode o projeto como um projeto String.
As operações podem ser realizadas acessando as seguintes rotas:

*Retorna uma lista com todos os produtos na base de dados*
http://localhost:8080/api/v1/nunessports/products

*Seleciona um produto dentre os presentes na base de dados. Requer que o id do produto seja passado na URL*
http://localhost:8080/api/v1/nunessports/product/ {id do produto}

*Cria um novo produto na base de dados. Os campos necessários são {code: String, name: String, description: String, price: number}*
http://localhost:8080/api/v1/nunessports/registerProduct

*Atualiza um produto existente na base de dados. Requer que o id do produto seja passado na URL. Os campos que podem ser atualizados são {code: String, name: String, description: String, price: number}*
http://localhost:8080/api/v1/nunessports/updateProduct/ {id do produto}

*Deleta um produto existente na base de dados. Requer que o id do produto seja passado na URL*
http://localhost:8080/api/v1/nunessports/deleteProduct/ {id do produto}

## Como realizar a integração entre os sistemas

Basta rodar este e o sistema Everymind-Challenge-Frontend simultaneamente em uma mesma máquina. As rotas dos projetos já estão configuradas para se integrarem.

## TO-DO LIST
- Integrar PostgreSQL na aplicação;
- Tratar exceções nos métodos do CRUD;
- Implementar testes unitários;
- Criar uma documentação do Swagger para a aplicação;
- Talvez implementar um sistema de JWT para a aplicação.

# Avaliacao-ekan

## 1 – Crie uma aplicação utilizando Java e Spring Boot que forneça uma API REST para manter o
cadastro de beneficiários de um plano de saúde.
Devem ser expostos endpoints para executar as seguintes operações:
- Cadastrar um beneficiário junto com seus documentos;
- Listar todos os beneficiários cadastrados;
- Listar todos os documentos de um beneficiário a partir de seu id;
- Atualizar os dados cadastrais de um beneficiário;
- Remover um beneficiário.
  
## 2 – Crie uma aplicação front-end que consuma esta API e execute as operações acima
  Instruções:
- O prazo para a conclusão é de 5 dias contados a partir da data de recebimento deste teste;
- Os dados devem ser salvos em um banco de dados relacional de sua escolha, podendo este
  ser um banco de dados embarcado, como H2 ou Derby;
- A implementação de um processo de autenticação/autorização será considerada um
  diferencial;
- Após a conclusão commitar o código em um repositório no GitHub e enviar o link para
  pdantas@ekan.com.br;
- No repositório, criar um arquivo readme.md explicando como a aplicação foi desenvolvida e
  as instruções para executar o build.
  
## Clonando o repositório

1. Abra um terminal ou prompt de comando.
2. Navegue até o diretório onde deseja clonar o repositório.
3. Execute o seguinte comando para clonar o repositório: `git clone <url_do_repositório>`

## Iniciando o servidor de aplicativos Spring Boot

1. Navegue até o diretório onde você clonou o repositório.
2. Execute o seguinte comando para iniciar o servidor de aplicativos Spring Boot: `./mvnw spring-boot:run`

## Iniciando o frontend ReactJS

1. Abra uma nova janela de terminal ou prompt de comando.
2. Navegue até o diretório onde você clonou o repositório.
3. Execute o seguinte comando para instalar as dependências: `npm install`
4. Execute o seguinte comando para iniciar o frontend ReactJS: `npm start`

## Acessando o console do banco de dados H2

1. Abra um navegador da web e navegue até `http://localhost:8080/h2-console`.
2. Insira a URL JDBC, nome de usuário e senha do seu banco de dados H2 e clique em "Conectar".

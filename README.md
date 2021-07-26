# Sistema de Gerenciamento de Aunos

Esta é um sistema em implementado com o proposito de desenvolver uma aplicação de controle de gerenciamento de alunos. O sistema trata-de um projeto com base **Maven**, **SringBoot** para realização de persistencias e interface com banco de dados **Postgres**. No frontend foi utilizado o **Vue** e **Vuetify**.

#### Criação de uma tabela Alunos:
- [x] Implementação do cadastro;
- [x] Implementação de listagem;
- [x] Implementação de exclusão;
- [x] Implementação de edição;

#### Criação de uma tabela Endereço:
Essa tabela armaneza o endereço do aluno cadastrado. O mapeamento utilizado é pensando que cada aluno pode ter somente um endereço

## Configurações do sistema
- Faça o **clone** deste repositório;

### Banco de dados
- crie um novo banco **Postgres** com o nome `colegio`
### Backend
- Utilziando **Intellij**
**Importar -> Open**;
- Selecione a pasta backend deste repositório e **OK**.
- No arquivo `application.properties` sete o local COMPLETO em que serão salvas as fotos no diretório do frontend:
`scitc.upload.src=/home/igor/Documentos/git/Pessoal/sistema_gerencia_alunos/frontend/public/uploads`
- caso o usuário e senha sejam diferentes de `postgres` ajustar no arquivo `application.properties`.
- Execute a aplicação.

### Frontend
- Entre no diretorio do frontend;
- `npm install` para instalar as dependências;
- `npm run serve` para executar a aplicação.
- No seu navegador de web preferencial entre com **http://localhost:8080**;

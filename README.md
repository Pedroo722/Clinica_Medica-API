# Clínica Médica API

Projeto back-end criado para a disciplina de **Desenvolvimento de Aplicações Web II**. A aplicação foi construída utilizando **Spring Boot** e **PostgreSQL** como banco de dados, visando criar uma API REST para a consulta de informações de um banco de dados de uma Clínica Médica fictícia desenvolvida como parte da disciplina de **Banco de Dados 1**.

Membros do Projeto:
- Pedro Henrique Alexandre.
- Vinicius Cavalcante Pequeno.
- Thiago dos Santos Araújo (como parte da matéria de Análise e Projeto de Sistemas).

## Tecnologias Usadas

<div align="center">

![Java 17](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot 3](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)

</div>

## Funcionalidades

* **Login e Autenticação de Usuário**
* **Cadastro e Gerenciamento de Pacientes**
* **Agendamento de Consultas Médicas**
* **Visualização de Disponibilidade de Médicos**
* **Cadastro de Serviço, Exames e Procedimentos Médicos**
* **Registro de Fichas Médicas**


## Estrutura dos Arquivos

- **Controllers**: Responsáveis por definir os endpoints da API.
- **Model**: Representa as entidades do banco de dados e seus atributos.
- **Repositories**: Arquivos que fazem a conexão com o banco de dados.
- **Services**: Contêm a lógica de negócio para manipular e consultar os dados.

## Como Executar
### Pré-requisitos

- **Java 17** ou superior
- **Maven** 3.8.1+
- **PostgreSQL**

### Passos para execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/Pedroo722/Clinica_Medica-API.git
   cd .\Clinica_Medica-API\
   ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API em: `http://localhost:8080/api/{endpoint}`.


## Endpoints

A API fornece os seguintes endpoints para a manipulação de dados relacionados a médicos, consultas, pacientes, serviços e fichas médicas. Cada endpoint permite as operações básicas CRUD.

### Paciente
- **GET** `/api/patient/{id}`: Recupera um paciente pelo ID.
- **POST** `/api/patient`: Cria um novo paciente.
- **PUT** `/api/patient/{id}`: Atualiza um paciente existente.
- **DELETE** `/api/patient/{id}`: Remove um paciente pelo ID.
- **GET** `/api/patient`: Recupera todos os pacientes.

### Consulta
- **GET** `/api/consultation/{id}`: Recupera uma consulta pelo ID.
- **POST** `/api/consultation`: Cria uma nova consulta.
- **PUT** `/api/consultation/{id}`: Atualiza uma consulta existente.
- **DELETE** `/api/consultation/{id}`: Remove uma consulta pelo ID.
- **GET** `/api/consultation`: Recupera todas as consultas.

### Médico
- **GET** `/api/medic/{id}`: Recupera um médico pelo ID.
- **POST** `/api/medic`: Cria um novo médico.
- **PUT** `/api/medic/{id}`: Atualiza um médico existente.
- **DELETE** `/api/medic/{id}`: Remove um médico pelo ID.
- **GET** `/api/medic`: Recupera todos os médicos.

### Ficha
- **GET** `/api/record/{id}`: Recupera um registro pelo ID.
- **POST** `/api/record`: Cria um novo registro.
- **PUT** `/api/record/{id}`: Atualiza um registro existente.
- **DELETE** `/api/record/{id}`: Remove um registro pelo ID.
- **GET** `/api/record`: Recupera todos os registros.

### Serviço
- **GET** `/api/service/{id}`: Recupera um serviço pelo ID.
- **POST** `/api/service`: Cria um novo serviço.
- **PUT** `/api/service/{id}`: Atualiza um serviço existente.
- **DELETE** `/api/service/{id}`: Remove um serviço pelo ID.
- **GET** `/api/service`: Recupera todos os serviços.

## Estrutura dos Dados
### Paciente
Representa um paciente e suas informações básicas.

```json
{
    "id": 1,
    "nome": "Hugo",
    "sexo": "Masculino",
    "telefone": "9876543216",
    "email": "hugo.pa@gmail.com",
    "endereco": "Centro",
    "data_nascimento": "1996-01-01T00:00:00-02:00",
    "cpf": "230.333.666-98"
}
``` 

### Consulta

Contém a data e horário do agendamento de uma consulta.

```json
{
    "id": 1,
    "data": "2024-05-21",
    "horario": "11:30:00"
}
```


### Médico
Contém os dados de contato e disponibilidade de um médico.

```json
{
    "id": 1,
    "nome": "Francisco",
    "sexo": "Masculino",
    "contato": "9876543210",
    "especialidade": "Cardiologista",
    "disponibilidade": true
}
```

### Ficha
Representa as informações da ficha médica de um paciente.

```json
{
    "id": 1,
    "diagnostico": "doença cardiaca",
    "historico_medico": "pai com historico de doença cardiaca",
    "status": "em andamento",
    "id_paciente": 1,
    "id_medico": 1
}

```

### Serviço
Contém as informações dos serviços médicos do hospital.

```json
{
    "id": 1,
    "tipo": "Cardiaco",
    "requisito": "exames cardiacos",
    "equipamento": "equipamentos cardiacos",
    "descricao": "consulta cardiaca",
    "id_medico": 1
}
```

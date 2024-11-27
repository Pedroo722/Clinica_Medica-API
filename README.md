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
* **Cadastro de Exames e Procedimentos Médicos**
* **Criação de Receitas**
* **Registro de Fichas Médicas**


## Estrutura dos Arquivos

- **Controller**: Responsáveis por definir os endpoints da API.
- **Model**: Representa as entidades do banco de dados e seus atributos.
- **Repository**: Arquivos que fazem a conexão com o banco de dados.
- **Service**: Contêm a lógica de negócio para manipular e consultar os dados.

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

A API fornece os seguintes endpoints para a manipulação de dados relacionados a pacientes, médicos, consultas, receitas e fichas médicas. Cada endpoint permite as operações básicas CRUD.

### Paciente
- **GET** `/api/patients/{id}`: Recupera um paciente pelo ID.
- **POST** `/api/patients`: Cria um novo paciente.
- **PUT** `/api/patients/{id}`: Atualiza um paciente existente.
- **DELETE** `/api/patients/{id}`: Remove um paciente pelo ID.
- **GET** `/api/patients`: Recupera todos os pacientes.

### Consulta
- **GET** `/api/consultations/{id}`: Recupera uma consulta pelo ID.
- **POST** `/api/consultations`: Cria uma nova consulta.
- **PUT** `/api/consultations/{id}`: Atualiza uma consulta existente.
- **DELETE** `/api/consultations/{id}`: Remove uma consulta pelo ID.
- **GET** `/api/consultations`: Recupera todas as consultas.

### Médico
- **GET** `/api/medics/{id}`: Recupera um médico pelo ID.
- **POST** `/api/medics`: Cria um novo médico.
- **PUT** `/api/medics/{id}`: Atualiza um médico existente.
- **DELETE** `/api/medics/{id}`: Remove um médico pelo ID.
- **GET** `/api/medics`: Recupera todos os médicos.

### Ficha
- **GET** `/api/records/{id}`: Recupera um registro pelo ID.
- **POST** `/api/records`: Cria um novo registro.
- **PUT** `/api/records/{id}`: Atualiza um registro existente.
- **DELETE** `/api/records/{id}`: Remove um registro pelo ID.
- **GET** `/api/records`: Recupera todos os registros.

### Receita
- **GET** `/api/recipes/{id}`: Recupera uma receita pelo ID.
- **POST** `/api/recipes`: Cria uma nova receita.
- **PUT** `/api/recipes/{id}`: Atualiza uma receita existente.
- **DELETE** `/api/recipes/{id}`: Remove uma receita pelo ID.
- **GET** `/api/recipes`: Recupera todas as receitas.

## Estrutura dos Dados
### Paciente
Representa um paciente e suas informações básicas.

```json
{
    "id": 1,
    "nome": "Hugo",
    "sexo": "Masculino",
    "cpf": "230.333.666-98",
    "email": "hugo.pa@gmail.com",
    "telefone": "9876543216",
    "endereco": "Rua Exemplo, 123, Centro",
    "data_nascimento": "1996-01-01T00:00:00-02:00",
    "tipo_sanguineo": "B+",
    "identificador_tarefa": 1
}
```

### Consulta

Contém a data e horário do agendamento de uma consulta.

```json
{
    "id": 1,
    "data": "2024-05-21",
    "horario": "11:30:00",
    "status": "Agendada",
    "tipo": "Exame Sanguíneo",
    "id_paciente": 1,
    "id_medico": 1
}
```


### Médico
Contém os dados de contato e disponibilidade de um médico.

```json
{
    "id": 1,
    "nome": "Francisco",
    "email": "franciscoexemplo@gmai.com",
    "telefone": "9876543210",
    "especialidade": "Cardiologista",
    "status_disponibilidade": "Indísponível",
    "crm": "00000000-0/BR"
}
```

### Ficha
Representa as informações da ficha médica de um paciente.

```json
{
    "id": 1,
    "status_paciente": "Estável.",
    "historico_medico": "Pai com historico de doença cardiaca.",
    "diagnostico": "Doença cardiaca.",
    "tratamento": "Cirurgia cardiovascular.",
    "observacoes": "",
    "id_paciente": 1
}

```

### Receita
Representa as informações referentes a receita de uma consulta.

```json
{
    "id": 1,
    "medicamentos_prescritos": "Xarópe.",
    "validade": "01/12/2025",
    "observacoes": "",
    "id_consulta": 1,
    "id_medico": 1
}

```
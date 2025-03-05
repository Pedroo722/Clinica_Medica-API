# Clínica Médica API

Projeto back-end criado para a disciplina de **Desenvolvimento de Aplicações Web II** e aproveitado na matéria de **Análise e Projeto de Sistemas**. A aplicação foi construída utilizando **Spring Boot** e **PostgreSQL** como banco de dados, visando criar uma API REST para a consulta de informações de um banco de dados de uma Clínica Médica fictícia originalmente desenvolvido como parte da disciplina de **Banco de Dados 1**.

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

* **Cadastro e Gerenciamento de Pacientes**
* **Agendamento de Consultas Médicas**
* **Cadastro de Exames e Procedimentos Médicos**
* **Criação de Receitas Médicas**
* **Registro de Fichas Médicas**


## Estrutura dos Arquivos

- **Controller**: Responsáveis por definir os endpoints da API.
- **Model**: Representa as entidades do banco de dados e seus atributos.
- **Repository**: Arquivos que fazem a conexão com o banco de dados.
- **Service**: Contêm a lógica de negócio para manipular e consultar os dados.
- **Util**: Contêm arquivos com metodos de validação dos dados das entidades da clínica.

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


5. Acesse a UI do Swagger em `http://localhost:8080/swagger-ui/index.html#/`.


## Endpoints

A API fornece os seguintes endpoints para a manipulação de dados relacionados a pacientes, médicos, consultas, receitas e fichas médicas. Cada endpoint permite as operações básicas CRUD.

### Paciente
- **GET** `/api/patients/list`: Recupera todos os pacientes. Permitindo a filtragem pelos parametros *`?name=`* & *`?cpf=*`*.
- **GET** `/api/patients/list/{id}`: Recupera um paciente pelo ID.
- **POST** `/api/patients/create`: Cria um novo paciente.
- **PUT** `/api/patients/update/{id}`: Atualiza um paciente existente.
- **DELETE** `/api/patients/delete/{id}`: Remove um paciente pelo ID.

### Consulta
- **GET** `/api/consultations/list`: Recupera todas as consultas.
- **GET** `/api/consultations/list/{id}`: Recupera uma consulta pelo ID.
- **POST** `/api/consultations/create`: Cria uma nova consulta.
- **PUT** `/api/consultations/update/{id}`: Atualiza uma consulta existente.
- **DELETE** `/api/consultations/delete/{id}`: Remove uma consulta pelo ID.

### Médico
- **GET** `/api/medics/list`: Recupera todos os médicos. Permitindo a filtragem pelos parametros *`?name=`* & *`?crm=*`*.
- **GET** `/api/medics/list/{id}`: Recupera um médico pelo ID.
- **POST** `/api/medics/create`: Cria um novo médico.
- **PUT** `/api/medics/update/{id}`: Atualiza um médico existente.
- **DELETE** `/api/medics/delete/{id}`: Remove um médico pelo ID.

### Ficha
- **GET** `/api/records/list`: Recupera todos os registros. Permitindo a filtragem por meio do parametro *`?id_paciente=`*.
- **GET** `/api/records/list/{id}`: Recupera um registro pelo ID.
- **POST** `/api/records/create`: Cria um novo registro.
- **PUT** `/api/records/update/{id}`: Atualiza um registro existente.
- **DELETE** `/api/records/delete/{id}`: Remove um registro pelo ID.

### Receita
- **GET** `/api/recipes/list`: Recupera todas as receitas.
- **GET** `/api/recipes/list/{id}`: Recupera uma receita pelo ID.
- **POST** `/api/recipes/create`: Cria uma nova receita.
- **PUT** `/api/recipes/update/{id}`: Atualiza uma receita existente.
- **DELETE** `/api/recipes/delete/{id}`: Remove uma receita pelo ID.

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
}

```
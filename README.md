
# API de Registro de Vendedores

Este projeto consiste em uma API para registro de vendedores e suas respectivas regiões de atuação. Ela fornece endpoints para gerenciar os dados dos vendedores.

# Recursos

- API de registro de vendedores
- Validação de dados usando a validação do Spring Boot
- Armazenamento de dados usando o Spring Data JPA
- Mapeamento de objetos usando o ModelMapper
- Banco de dados H2 em memória para desenvolvimento e testes locais

# Pré-requisitos

- Java Development Kit (JDK) 11 ou superior
- Apache Maven

# Execute a aplicação
    mvn spring-boot:run

A aplicação será iniciada em 
- localhost:8080/salesPerson/vendedor (POST)
- localhost:8080/salesPerson/vendedor/1 (GET/{id})
- localhost:8080/salesPerson/vendedor (GET)
- localhost:8080/salesPerson/atuacao (PUT)

### Criando um novo vendedor

```
POST /salesPerson/vendedor
Accept: application/json
Content-Type: application/json

{
   "nome":"Daniel Santos",
   "telefone":"83 91234-5678",
   "idade":25,
   "cidade":"Joao Pessoa",
   "estado": "PB",
   "estados":[      
         "PB"
   ],
   "regiao":"NORDESTE"
}

RESPONSE: HTTP 201 (Created)
```

### Atualizando um novo campo de atuação
```
PUT /salesPerson/atuacao
Accept: application/json
Content-Type: application/json

{
"id": 1,
"regiao": "NORDESTE",
"estados": ["PB", "CE", "PE", "SP"]
}

RESPONSE: HTTP 200 (OK)
```
### Listando vendedores cadastrados
```
GET /salesPerson/vendedor
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 200 (OK)

{
    "id": 1,
    "dataInclusao": "2023-05-15",
    "nome": "Daniel Santos",
    "telefone": "83 91234-5678",
    "idade": 25,
    "cidade": "Sao Paulo",
    "estado": "SP",
    "estados": [
        "SP"
    ],
    "regiao": "SUDESTE"
}
```
### Listando vendedores cadastrados por ID
```
GET /salesPerson/vendedor/2
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 200 (OK)

{
    "id": 2,
    "dataInclusao": "2023-05-15",
    "nome": "Fernando Souza",
    "telefone": "83 98765-5678",
    "idade": 32,
    "cidade": "Sao Paulo",
    "estado": "SP",
    "estados": [
        "SP"
    ],
    "regiao": "SUDESTE"
}
```
```
datasource:
spring.datasource.url=jdbc:h2:mem:demo;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true


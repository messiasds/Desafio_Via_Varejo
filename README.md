# Desafio  

## Tecnologias

SpringBoot

MongoDb

Docker

## Requisitos não cumpridos

*. Numero da apolice aleatório e único

*. CPF único

## API

### Clientes

**Estrutura do JSON**

```json
{
        "id": "50",
        "nome": "José Silva",
        "cpf": "48373066080",
        "cidade": "Jacareí",
        "uf": "SP"
}
```


**/api/clientes** - GET - listar todos  

**/api/clientes/{id}** - GET - buscar um cliente

**/api/clientes** - POST - salvar cliente

**/api/clientes/{id}** - PUT - editar cliente

**/api/clientes/{id}** - DELETE - deletar um cliente


### apolices

**Estrutura do JSON**
```json

        "id":"3",
        "numero":"333",
        "vigenciaInicio":"2019-01-01",
        "vigenciaFim":"2021-02-10",
        "placaVeiculo":"DBZ2222",
        "valor":"3000",
        "cliente":{
                "id":"50"
        }
}


**/api/apolices** - GET - listar todos 

**/api/apolices/{id}** - GET - buscar uma apolice

**/api/apolices** - POST - salvar apolice

**/api/apolices/{id}** - PUT - editar apolice

**/api/apolices/{id}** - DELETE - deletar uma apolice


### Consulta de apólice

**Estrutura do Json**

```json
{
    "numero": 333,
    "vigenciaInicio": "2019-01-01",
    "vigenciaFim": "2021-02-10",
    "placaVeiculo": "DBZ2222",
    "valor": 3000,
    "vencida": false,
    "diasVencida": 0,
    "diasParaVencer": 13
}
```

**/api/consultas/api/apolice/{id} - GET - mostrar dados da apolice e dados do vencimento


### Como executar o projeto

**Backend Spring**

Executar o JAR que está na direto /build/libs/

```
java -jar Seguradora-0.0.1-SNAPSHOT.jar
```



**BD**

Para o banco de dados foi utilizado uma imagem do mongoDb no docker

```
docker run -d --name mongodb -p 27017:27017 -p 28017:28017 -e AUTH=no mongo
```





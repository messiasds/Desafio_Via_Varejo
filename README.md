# Desafio  

## Tecnologias

SpringBoot
MongoDb
Docker

## API

### Clientes

**/api/clientes** - GET - listar todos  
**/api/clientes/{id}** - GET - buscar um cliente
**/api/clientes** - POST - salvar cliente
**/api/clientes/{id}** - PUT - editar cliente
**/api/clientes/{id}** - DELETE - deletar um cliente
### apolices

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

## Como executar o projeto

...





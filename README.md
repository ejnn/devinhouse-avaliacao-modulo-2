# DEVinHouse
Esta é a minha versão do primeiro projeto do segundo módulo do DEVinHouse!

## Sobre
Este projeto consiste na criação de uma API CRUD (de processos, em JSON) utilizando [Spring Boot](https://spring.io/projects/spring-boot)!

## Rodando o projeto
É só clonar e ```mvn spring-boot:run```! :sunglasses:

## Exemplo de Processo
```json
{
  "id": 0,
  "entrada": "2021-04-21",
  "codigo": "SOFT 2021/0",
  "assunto": "<insira um assunto aqui>",
  "descricao": "este é um exemplo de processo retornado pelo backend",
  "interessados": [ "<insira seu nome aqui>" ]
}
```

## Endpoints

+ ```/v1/processo[/<id>]``` para cadastrar, consultar, atualizar ou deletar processos;\
(```/v1/processo?codigo=<codigo>``` é outra possibilidade para consultas!)
+ ```/v1/processos``` para consultar todos os processos cadastrados.

## Exemplos
+ ```GET .../v1/processo?codigo=SOFT 2021/0```
+ ```DELETE .../v1/processo/0```

# XY Inc. Localizador POI

API para localizar de pontos de interesse

## O Projeto
Projeto inovador para auxiliar pessoas na localização de pontos de interesse (POI). Pode ser utilizado em uma diversidade de dispositivos que implementam o protocolo HTTP.

## Built With

Projeto criado utilizando as ferramentas: 
* [Spring Framework](https://spring.io/) - Arquitetura da Aplicação
* [Maven](https://maven.apache.org/) - Gerenciador de Dependencias
* [MongoDB](https://www.mongodb.com/) - Document Database
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE

## Get Started
Para execução do projeto são necessárias algumas ferramentas e pacotes:
* [Java SE Development Kit 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3.2+](https://maven.apache.org/download.cgi)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

Abra a pasta do projeto com a IDE de preferencia, e rode o projeto. De exemplo foi utilizado a IDE [IntelliJ](https://www.jetbrains.com/idea/) 

## Documentação API
**Cadastrar POI**
----
  Cadastra ou atualiza um novo ponto de interesse. A chave do POI é dado pelo campo "name". Os parametros "point_x" e "point_y" devem ser inteiros não negativos e o parametro "name" 
 deve ser informado.
* **Endpoint:**
  /poi

* **Method:**
  `PUT`
  
* **Body:**
`{
 	"name": "Hospital",
 	"point_x": 40,
 	"point_y": 3
 }`

* **Sucesso:**
  * **Code:** 200 <br />
 
* **Erro:**

  * **Code:** 500 INTERNAL SERVER ERROR <br />
    **Content:** `"Erro interno.`

  OR

  * **Code:** 400 BAD REQUEST <br />
    A entrada deve ser informada de acordo com a especificação.

* **Exemplo:**

  ```
  {
    "name": "Supermercado",
    "point_x": 41,
    "point_y": 34
  }
  ```
**Listar POIs**
----
  Lista todos os POI's cadastrados na base de dados.
* **Endpoint:**
  /poi

* **Method:**
  `GET`
  
* **Sucesso:**
  * **Code:** 200 <br />
    **Content:** 
    ```
    [
        {
            "name": "Lanchonete",
            "point_x": 27,
            "point_y": 12
        },
        {
            "name": "Posto",
            "point_x": 31,
            "point_y": 18
        },
        {
            "name": "Joalheria",
            "point_x": 15,
            "point_y": 12
        },
        {
            "name": "Floricultura",
            "point_x": 19,
            "point_y": 21
        },
        {
            "name": "Pub",
            "point_x": 12,
            "point_y": 8
        },
        {
            "name": "Supermercado",
            "point_x": 23,
            "point_y": 6
        },
        {
            "name": "Churrascaria",
            "point_x": 28,
            "point_y": 2
        }
    ]
    ```
* **Erro:**

  * **Code:** 500 INTERNAL SERVER ERROR <br />
    **Content:** `"Erro interno.`
    
**Consultar POI proximos**
----
  Consulta todos os pontos de interesse até uma determinada distancia e a partir de um ponto de referencia informado. O parametro "max_distance" deve ser inteiro não negativo.
* **Endpoint:**
  /poi/findnearest

* **Method:**
  `POST`
  
* **Body:**
`{
 	"max_distance": 10,
 	"point_x": 20,
 	"point_y": 10
 }`

* **Sucesso:**
  * **Code:** 200 <br />
  * **Content:**
   ```
  [
      {
          "name": "Lanchonete",
          "point_x": 27,
          "point_y": 12
      },
      {
          "name": "Joalheria",
          "point_x": 15,
          "point_y": 12
      },
      {
          "name": "Pub",
          "point_x": 12,
          "point_y": 8
      },
      {
          "name": "Supermercado",
          "point_x": 23,
          "point_y": 6
      }
  ]
  ```
 
* **Erro:**

  * **Code:** 500 INTERNAL SERVER ERROR <br />
    **Content:** `"Erro interno.`
    
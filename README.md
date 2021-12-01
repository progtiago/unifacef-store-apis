# unifacef-store-apis

Aplicação para agregar produtos, preços e posições de estoque num único payload simulando um ecommerce. 
Essa aplicação é utilizada na disciplina de Apis Rest com Java e Spring da UNIFACEF. 

## Exercício

Criar serviços que permitam o cadastro de Produto/Preço/Estoque em microsserviços apartados, cada qual com suas respectivas validações.
Também deverá ser criado um microsserviço de agregação onde os payloads oriundos dos microsserviços especialistas devem ser agregados.

## A solução

![image](https://user-images.githubusercontent.com/595044/144319403-2fe3b312-4a9d-4df8-9d21-e79558bb52f6.png)

**Product-Apis:** Microsserviço responsável pelo CRUD de produtos via HTTP, por persistir no mongo e enviar para o Store-Apis.
**Price-Apis:** Microsserviço responsável pelo CRUD de preços via HTTP, por persistir no mongo e enviar para o Store-Apis.
**Iventory-Apis:** Microsserviço responsável pelo CRUD de posições de estoque via HTTP, por persistir no mongo e enviar para o Store-Apis.
**Store-Apis:** Microsserviço responsável por agregar os dados oriundos dos microsserviços de entrada.

## Contratos da api de store:

- POST /api/v1/products/{productCode}

```
{
  "name": "string",
  "description": "string",
  "brand": "string",
  "images": [
    "string"
  ],
  "attributes": [
    {
      "key": "string",
      "value": "string"
    }
  ]
}
```


- POST /api/v1/products/{productCode}/prices

```
{
  "from": "Double",
  "to": "Double"
}
```

- POST /api/v1/products/{productCode}/inventories

```
{
  "position": "Intenger"
}
```

- GET /api/v1/products/{productCode}

```
{
  "productCode": "string",
  "product": {
    "name": "string",
    "description": "string",
    "brand": "string",
    "images": [
      "string"
    ],
    "attributes": [
      {
        "key": "string",
        "value": "string"
      }
    ]
  },
  "price": {
    "from": "Double",
    "to": "Double"
  },
  "inventory": {
    "position": "Integer"
  },
  "createdDate": "LocalDateTime",
  "lastModifiedDate": "LocalDateTime"
}
```

- GET /api/v1/products

```
{
  "items": [
    {
      "productCode": "string",
      "product": {
        "name": "string",
        "description": "string",
        "brand": "string",
        "images": [
          "string"
        ],
        "attributes": [
          {
            "key": "string",
            "value": "string"
          }
        ]
      },
      "price": {
        "from": "Double",
        "to": "Double"
      },
      "inventory": {
        "position": "Integer"
      },
      "createdDate": "LocalDateTime",
      "lastModifiedDate": "LocalDateTime"
    }
  ],
  "page": "Integer",
  "size": "Integer",
  "totalPages": "Integer",
  "totalElements": "Integer"
}
```

## Tecnologias utilizadas

- Java 8
- MongoDB
- Lombok
- Spring Boot
- Spring Data
- Open Feign
- FF4J

### Para subir essa APP

- Criar um banco de dados mongo local chamado *store-product-api*, ou alterar o arquivo application.yml atualizando-o para o endereço mongo correto.
- Após subir essa aplicação ficará disponível em http://localhost:8084
- Swagger disponível em: http://localhost:8084/swagger-ui.html
- FF4J disponível em: http://localhost:8084/ff4j-console/

## Contatos

prog.tiago@gmail.com

https://www.linkedin.com/in/tiago-silva-644b0533/




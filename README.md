<h1 align="center">
  <a id="topo">Projeto Autobots </a>
</h1>

<p align="center"> 
  <a href="#descricao"> Descrição do projeto </a> • <a href="#tecnologias">Tecnologias utilizadas </a> • <a href="#rotas"> Rotas </a> • <a href="#licenca"> Licença </a>
</p>

## <a id="descricao"> Descrição do projeto </a>

Conjunto de atividades práticas realizadas durante a aula de Desenvolvimento Web III na Fatec, que consiste no desenvolvimento de uma aplicação chamada Autobots. 
Durante a primeira atividade, foi necessário criar um CRUD para Cliente, Endereço, Telefones e Documentos.

> 📌 Status do projeto: Em progresso.

<a href="#topo">↑ voltar ao topo </a>

## <a id="tecnologias"> Tecnologias utilizadas </a>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

<a href="#topo">↑ voltar ao topo </a>

## <a id="rotas"> Rotas </a>
<details>
  <summary> <b> 🙋 Cliente (clique para expandir) </b></summary>

  #### 🔸 Listar todos os clientes

  Método utilizado: ```GET```

  Url da rota:
  ``` 
  http://localhost:5000/clientes 
  ```

  Body da requisição: A requisição não possuí body.

  #### 🔸 Listar clientes pelo ID

  Método utilizado: ```GET```

  Url da rota:
  ``` 
  http://localhost:5000/cliente/{ID}
  ```

  Body da requisição: A requisição não possuí body.

  #### 🔸 Cadastrar cliente

  Método utilizado: ```POST```

  Url da rota:
  ``` 
  http://localhost:5000/cliente/cadastro
  ```

  Body da requisição: Json com um objeto do tipo Cliente, como o exemplo a seguir.
  ```
  {
    "nome": "Pedro Alcântara de Bragança e Bourbon",
    "nomeSocial": "Dom Pedro",
    "dataNascimento": "2002-06-15T11:21:19.924+00:00",
    "dataCadastro": "2022-03-11T11:21:19.924+00:00",
    "documentos": [
      {
        "tipo": "RG",
        "numero": "1550"
      },
      {
        "tipo": "RG",
        "numero": "00100000001"
      }
    ],
    "endereco": {
      "estado": "Rio de Janeiro",
      "cidade": "Rio de Janeiro",
      "bairro": "Copacabana",
      "rua": "Avenida Atlântica",
      "numero": "1702",
      "codigoPostal": "22021001",
      "informacoesAdicionais": "Hotel Copacabana palace"
    },
    "telefones": [
      {
        "ddd": "21",
        "numero": "981234576"
      }
    ]
  }
  ```
  
  #### 🔸 Atualizar cliente pelo ID

  Método utilizado: ```PUT```

  Url da rota:
  ``` 
  http://localhost:5000/cliente/atualizar
  ```

  Body da requisição: Json com um objeto do tipo Cliente, já com os campos editados e o ID passado deve ser o ID do cliente que será editado, como o exemplo a seguir.
  ```
  {
    "id": 1,
    "nome": "Pedro Alcântara",
    "nomeSocial": "Dom Pedro",
    "dataNascimento": "2002-06-15T11:21:19.924+00:00",
    "dataCadastro": "2022-03-11T11:21:19.924+00:00",
    "documentos": [
      {
          "id": 1,
          "tipo": "RG",
          "numero": "1500"
        },
        {
          "id": 2,
          "tipo": "RG",
          "numero": "00000000001"
        }
      ],
      "endereco": {
        "id": 1,
        "estado": "Rio de Janeiro",
        "cidade": "Rio de Janeiro",
        "bairro": "Copacabana",
        "rua": "Avenida Atlântica",
        "numero": "1702",
        "codigoPostal": "22021001",
        "informacoesAdicionais": "Hotel Copacabana palace"
      },
      "telefones": [
        {
          "id": 1,
          "ddd": "21",
          "numero": "981234576"
        }
      ]
    }
  ```
  
  #### 🔸 Deletar cliente pelo ID

  Método utilizado: ```DELETE```

  Url da rota:
  ``` 
  http://localhost:5000/cliente/excluir
  ```

  Body da requisição: Json com um objeto do tipo Cliente, onde o ID passado deve ser o ID do cliente que será deletado, como o exemplo a seguir.
  ```
    {
      "id": 6,
      "nome": "Pedro Alcântara",
      "nomeSocial": "Dom Pedro",
      "dataNascimento": "2002-06-15T11:21:19.924+00:00",
      "dataCadastro": "2022-03-11T11:21:19.924+00:00",
      "documentos": [
        {
          "id": 1,
          "tipo": "RG",
          "numero": "1500"
        },
        {
          "id": 2,
          "tipo": "RG",
          "numero": "00000000001"
        }
      ],
      "endereco": {
        "id": 1,
        "estado": "Rio de Janeiro",
        "cidade": "Rio de Janeiro",
        "bairro": "Copacabana",
        "rua": "Avenida Atlântica",
        "numero": "1702",
        "codigoPostal": "22021001",
        "informacoesAdicionais": "Hotel Copacabana palace"
      },
      "telefones": [
        {
          "id": 1,
          "ddd": "21",
          "numero": "981234576"
        }
      ]
  }
  ```
 </details>
 
 <details>
  <summary> <b> 🏠 Endereço (clique para expandir) </b></summary>

  #### 🔸 Listar todos os endereços

  Método utilizado: ```GET```

  Url da rota:
  ``` 
  http://localhost:5000/enderecos
  ```

  Body da requisição: A requisição não possuí body.

  #### 🔸 Listar endereço pelo ID

  Método utilizado: ```GET```

  Url da rota:
  ``` 
  http://localhost:5000/endereco/{ID}
  ```

  Body da requisição: A requisição não possuí body.

  #### 🔸 Atualizar endereço pelo ID

  Método utilizado: ```PUT```

  Url da rota:
  ``` 
  http://localhost:5000/endereco/atualizar
  ```

  Body da requisição: Json com um objeto do tipo Cliente, já com os campos do endereço editados e o ID passado deve ser o ID do Cliente que terá o endereço editado, como o exemplo a seguir.
  ```
  {
    "id": 1,
    "endereco": {
      "estado": "São Paulo",
      "cidade": "Rio de Janeiro",
      "bairro": "Copacabana",
      "rua": "Avenida Atlântica",
      "numero": "1702",
      "codigoPostal": "22021001",
      "informacoesAdicionais": "Hotel Copacabana palace"
    }
  }
  ```
 </details>
 
 <details>
  <summary> <b> 📞 Telefones (clique para expandir) </b></summary>

  #### 🔸 Listar todos os telefones

  Método utilizado: ```GET```

  Url da rota:
  ``` 
  http://localhost:5000/telefones
  ```

  Body da requisição: A requisição não possuí body.

  #### 🔸 Listar telefone pelo ID

  Método utilizado: ```GET```

  Url da rota:
  ``` 
  http://localhost:5000/telefone/{ID}
  ```

  Body da requisição: A requisição não possuí body.

  #### 🔸 Cadastrar telefone

  Método utilizado: ```POST```

  Url da rota:
  ``` 
  http://localhost:5000/telefone/cadastro
  ```

  Body da requisição: Json com um objeto do tipo Cliente, onde o ID passado é o ID do cliente que receberá o telefone, como o exemplo a seguir.
  ```
  {
    "id": 1,
    "telefones": [{
        "ddd": "32",
        "numero": "568525550003232"
     }]
   }
  ```
  
  #### 🔸 Atualizar telefone pelo ID

  Método utilizado: ```PUT```

  Url da rota:
  ``` 
  http://localhost:5000/telefone/atualizar
  ```

  Body da requisição: Json com um objeto do tipo Cliente, com os campos do telefone editados e o ID do telefone passado deve ser o ID do telefone que será editado, assim como o ID do cliente passado deve ser o ID do cliente que será editado, como o exemplo a seguir.
  ```
  {
    "id": 1,
    "telefones": [{
        "id": 1,
        "ddd": "12",
        "numero": "00013232"
     }]
  }
  ```
  
  #### 🔸 Deletar telefone pelo ID

  Método utilizado: ```DELETE```

  Url da rota:
  ``` 
  http://localhost:5000/telefone/excluir
  ```

  Body da requisição: Json contendo o ID do cliente que terá o telefone excluído e o ID do telefone que será excluído, como o exemplo a seguir.
  ```
   {
    "id": 1,
    "idTelefone":1
   }
  ```
 </details>
 
 <details>
  <summary> <b> 🧾 Documentos (clique para expandir) </b></summary>

  #### 🔸 Listar todos os documentos

  Método utilizado: ```GET```

  Url da rota:
  ``` 
  http://localhost:5000/documentos
  ```

  Body da requisição: A requisição não possuí body.

  #### 🔸 Listar documento pelo ID

  Método utilizado: ```GET```

  Url da rota:
  ``` 
  http://localhost:5000/documento/{ID}
  ```

  Body da requisição: A requisição não possuí body.

  #### 🔸 Cadastrar documento

  Método utilizado: ```POST```

  Url da rota:
  ``` 
  http://localhost:5000/documento/cadastro
  ```

  Body da requisição: Json com um objeto do tipo Cliente, onde o ID passado é o ID do cliente que receberá o documento, como o exemplo a seguir.
  ```
  {
		"id": 1,
		"documentos": [
			{
				"tipo": "RG",
				"numero": "15670"
			}
		]
  }
  ```
  
  #### 🔸 Atualizar documento pelo ID

  Método utilizado: ```PUT```

  Url da rota:
  ``` 
  http://localhost:5000/documento/atualizar
  ```

  Body da requisição: Json com um objeto do tipo Cliente, com os campos do documento editados e o ID do documento passado deve ser o ID do documento que será editado, assim como o ID do cliente passado deve ser o ID do cliente que será editado, como o exemplo a seguir.
  ```
  {
		"id": 1,
		"documentos": [
			{
				"id": 1,
				"tipo": "RG",
				"numero": "1111111"
			}
		]
	}
  ```
  
  #### 🔸 Deletar telefone pelo ID

  Método utilizado: ```DELETE```

  Url da rota:
  ``` 
  http://localhost:5000/documento/excluir
  ```

  Body da requisição: Json contendo o ID do cliente que terá o documento excluído e o ID do documento que será excluído, como o exemplo a seguir.
  ```
  {
    "id": 1,
	  "idDocumento":1
  }
  ```
 </details>

<a href="#topo">↑ voltar ao topo </a>

## <a id="licenca"> Licença </a>

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](https://github.com/gioliveirass/fatec-TPI-world-beauty/blob/main/LICENSE) para mais detalhes.

<a href="#topo">↑ voltar ao topo </a>

<hr>
<p align="center">
  ✨ Projeto desenvolvido por <a href="https://github.com/gioliveirass">@gioliveirass</a> ✨
  <br><br>
  <img src="https://img.shields.io/badge/Made%20with-Magic-orange?style=for-the-badge&logo=data:image/svg%2bxml;base64,PHN2ZyBpZD0iQ2FwYV8xIiBlbmFibGUtYmFja2dyb3VuZD0ibmV3IDAgMCA1MTIgNTEyIiBoZWlnaHQ9IjUxMiIgdmlld0JveD0iMCAwIDUxMiA1MTIiIHdpZHRoPSI1MTIiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+PGc+PHBhdGggZD0ibTM5NS44MiAxODIuNjE2LTE4OC43MiAxODguNzItMTIuOTEgMS43Mi05LjM1IDIwLjU0LTM0LjMxIDM0LjMxLTExLjAxLS43My0xMS4yNSAyMi45OS01Ni40OCA1Ni40OGMtMi45MyAyLjkzLTYuNzcgNC4zOS0xMC42MSA0LjM5cy03LjY4LTEuNDYtMTAuNjEtNC4zOWwtMjIuNjItMjIuNjJoLS4wMWwtMjIuNjItMjIuNjNjLTUuODYtNS44Ni01Ljg2LTE1LjM2IDAtMjEuMjJsNzcuNjMtNzcuNjMgMTYuNi03LjAzIDUuNjYtMTUuMjMgMzQuMzEtMzQuMzEgMTQuODQtNC45MiA3LjQyLTE3LjM0IDE2Ny41Ny0xNjcuNTcgMzMuMjQgMzMuMjR6IiBmaWxsPSIjZjY2Ii8+PHBhdGggZD0ibTM5NS44MiAxMTYuMTQ2djY2LjQ3bC0xODguNzIgMTg4LjcyLTEyLjkxIDEuNzItOS4zNSAyMC41NC0zNC4zMSAzNC4zMS0xMS4wMS0uNzMtMTEuMjUgMjIuOTktNTYuNDggNTYuNDhjLTIuOTMgMi45My02Ljc3IDQuMzktMTAuNjEgNC4zOXMtNy42OC0xLjQ2LTEwLjYxLTQuMzlsLTIyLjYyLTIyLjYyIDMzNC42NC0zMzQuNjR6IiBmaWxsPSIjZTYyZTZiIi8+PHBhdGggZD0ibTUwNi42MSAyMDkuMDA2LTY5LjE0LTY5LjEzIDQzLjA1LTg4LjM4YzIuOC01Ljc1IDEuNjUtMTIuNjUtMi44OC0xNy4xNy00LjUyLTQuNTMtMTEuNDItNS42OC0xNy4xNy0yLjg4bC04OC4zOCA0My4wNS02OS4xMy02OS4xNGMtNC4zNS00LjM1LTEwLjkyLTUuNi0xNi41Ni0zLjE2LTUuNjUgMi40NS05LjIzIDguMDktOS4wNCAxNC4yNGwyLjg2IDkwLjQ1LTg1LjM3IDU3LjgzYy00LjkxIDMuMzItNy40IDkuMjItNi4zNiAxNS4wNCAxLjA0IDUuODMgNS40IDEwLjUxIDExLjE1IDExLjk0bDk2LjYyIDI0LjAxIDI0LjAxIDk2LjYyYzEuNDMgNS43NSA2LjExIDEwLjExIDExLjk0IDExLjE1Ljg3LjE2IDEuNzUuMjMgMi42Mi4yMyA0LjkyIDAgOS42LTIuNDIgMTIuNDItNi41OWw1Ny44My04NS4zNyA5MC40NSAyLjg2YzYuMTQuMTkgMTEuNzktMy4zOSAxNC4yNC05LjA0IDIuNDQtNS42NCAxLjE5LTEyLjIxLTMuMTYtMTYuNTZ6IiBmaWxsPSIjZmFiZTJjIi8+PHBhdGggZD0ibTI5Ni4yNiAyMTUuNzA2IDI0LjAxIDk2LjYyYzEuNDMgNS43NSA2LjExIDEwLjExIDExLjk0IDExLjE1Ljg3LjE2IDEuNzUuMjMgMi42Mi4yMyA0LjkyIDAgOS42LTIuNDIgMTIuNDItNi41OWw1Ny44My04NS4zNyA5MC40NSAyLjg2YzYuMTQuMTkgMTEuNzktMy4zOSAxNC4yNC05LjA0IDIuNDQtNS42NCAxLjE5LTEyLjIxLTMuMTYtMTYuNTZsLTY5LjE0LTY5LjEzIDQzLjA1LTg4LjM4YzIuOC01Ljc1IDEuNjUtMTIuNjUtMi44OC0xNy4xN3oiIGZpbGw9IiNmZDkwMjUiLz48cGF0aCBkPSJtNDY1IDQxNi45NjZjLTI1LjkyIDAtNDcgMjEuMDgtNDcgNDdzMjEuMDggNDcgNDcgNDcgNDctMjEuMDggNDctNDctMjEuMDgtNDctNDctNDd6IiBmaWxsPSIjZmFiZTJjIi8+PHBhdGggZD0ibTEwNCAyOC45NjZoLTEzdi0xM2MwLTguMjg0LTYuNzE2LTE1LTE1LTE1cy0xNSA2LjcxNi0xNSAxNXYxM2gtMTNjLTguMjg0IDAtMTUgNi43MTYtMTUgMTVzNi43MTYgMTUgMTUgMTVoMTN2MTNjMCA4LjI4NCA2LjcxNiAxNSAxNSAxNXMxNS02LjcxNiAxNS0xNXYtMTNoMTNjOC4yODQgMCAxNS02LjcxNiAxNS0xNXMtNi43MTYtMTUtMTUtMTV6IiBmaWxsPSIjZmVkODQzIi8+PHBhdGggZD0ibTIwNy4xIDM3MS4zMzYtMjIuMjYgMjIuMjYtNDUuMzItODcuNjIgMjIuMjYtMjIuMjZ6IiBmaWxsPSIjZmVkODQzIi8+PHBhdGggZD0ibTE4NC44NCAzOTMuNTk2IDIyLjI2LTIyLjI2LTIyLjY2LTQzLjgxLTIyLjI2NSAyMi4yNjV6IiBmaWxsPSIjZmFiZTJjIi8+PHBhdGggZD0ibTE1MC41MyA0MjcuOTA2LTIyLjI2IDIyLjI2LTQ1LjMyLTg3LjYyIDIyLjI2LTIyLjI2eiIgZmlsbD0iI2ZlZDg0MyIvPjxwYXRoIGQ9Im0xMjguMjcgNDUwLjE2NiAyMi4yNi0yMi4yNi0yMi42NTUtNDMuODE1LTIyLjI2IDIyLjI2eiIgZmlsbD0iI2ZhYmUyYyIvPjxjaXJjbGUgY3g9IjE1IiBjeT0iMTE5Ljk2OSIgZmlsbD0iIzVlZDhkMyIgcj0iMTUiLz48Y2lyY2xlIGN4PSIxMjgiIGN5PSIxOTkuOTY5IiBmaWxsPSIjZDU5OWVkIiByPSIxNSIvPjxjaXJjbGUgY3g9IjE5MiIgY3k9IjYzLjk2NCIgZmlsbD0iI2Y2NiIgcj0iMTUiLz48Y2lyY2xlIGN4PSIzMjgiIGN5PSI0MTUuOTY3IiBmaWxsPSIjMzFiZWJlIiByPSIxNSIvPjxjaXJjbGUgY3g9IjQ0MCIgY3k9IjMyNy45NjciIGZpbGw9IiNhZDc3ZTMiIHI9IjE0Ljk5OSIvPjwvZz48L3N2Zz4=">
</p>

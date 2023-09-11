# Webservice Desafio Place
# Sobre a API

**Webservice** que realiza requisições GET, POST, PUT e DELETE, usando Spring Boot e banco de dados MySql.

Link para a documentação completa no Swagger: http://localhost:8080/swagger-ui/index.html#/

Obs: Clicar após executar a API

## Configurações do aplication.properties

![properties](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/478af31f-d1a0-4d86-984c-a91c5ee05f4b)

Obs: Em spring.datasource.url, mudar o nome "webservicedesafio" para o nome de preferêcia do banco de dados.

## Configurações dos packages

- ## Entities

  - ### **Curso.java**  

  -   Cria a tabela tb_curso.
  -   Tem um relação de um para muitos com a tb_turm.

  - ### **Turma.java**
  -   Cria tabela tb_turma.
  -   Tem uma relação de muitos para um com a tb_curso.

- ## Controllers

  - ### **CursoController.java**  

  -   Realiza as requisições dos cursos.

  - ### **TurmaController.java**
  -   Realiza as requisições das turmas.

- ## Repositories
  - ### **CursoRepository.java**
  -  Repositório para cursos.

  - ### **TurmaRepository.java**
  -  Repositório para turmas.

- ## Services
  - ### **CursoService.java**
  -  Service para cursos.

  - ### **TurmaService.java**
  -  Service para turmas.

- ## Config
  - ### **TestConfig.java**
  -  Inicializa a API com dados específicos.


## Passo a Passo para realizar as requisições na API
  - ## /cursos
    - ## Adicionando um novo curso
      - #### ![post](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/c70342de-06da-4119-bc8b-9f2c3b91df4b)
      - ## Após clicar em "Execute" tem a seguinte resposta
      - ####![post_response](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/680eb816-de0b-4ff8-b475-6b3f5e7306f4)
        
    - ## Buscando todos os cursos
      - #### ![get_cursos](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/7ad8f97f-8958-44d6-ae91-78d0fb1d9846)
      - ## Após clicar em "Execute" tem a seguinte resposta
      - #### ![get_cursos_response](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/3c370c9e-397b-4dfe-8e5b-0d880db9583b)
        
    - ## Buscando um curso por id (/id)
      - #### ![get_cursos_id](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/0c1412be-d8a3-410c-a50d-267b21dcfefb)
      - ## Após clicar em "Execute" tem a seguinte resposta
      - #### ![get_cursos_id_response](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/9d8467f3-9d8f-49ee-9c5f-ac6dfeafcacc)

    - ## Atualizando curso por id (/id)
      - #### ![put](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/486e2614-72e4-4fff-bc31-f4ae978cebfe)
      - ## Após clicar em "Execute" tem a seguinte resposta
      - #### ![put_response](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/af2d9f9b-471c-4b47-84ed-bb7a6940bb5e)

    - ## Deletando curso por id (/id)
      - #### ![delete](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/80b02980-b860-4ca7-96d0-a6318103d383)
      - ## Após clicar em "Execute" tem a seguinte resposta
      - #### ![delete_response](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/3e5ac7b6-7e7e-425a-bd29-9759014feb6e)

   - ## /turmas
     - ## Buscando todas as turmas
       - #### ![get_turmas](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/2c9493f1-c1a1-4e8a-8727-457176e72eb8)
       - ## Após clicar em "Execute" tem a seguinte resposta
       - #### ![get_turmas_response](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/751e45d2-ab9a-4668-88c1-c92a2edab47c)


      - ## Buscando turma por id (/id)
        - #### ![get_turmas_id](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/4385b06b-2da2-4c59-a0eb-e7cbf1e3d456)
        - ## Após clicar em "Execute" tem a seguinte resposta
        - #### ![get_turmas_id_response](https://github.com/Rodrigo2898/webservice-desafio-place/assets/72587485/c7dd8d54-710d-42b0-8af5-0eb72b8d6b7a)
















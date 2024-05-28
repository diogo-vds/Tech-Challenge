Backend do projeto para um sistema de adoção de cães e gatos.
Commit inicial do projeto com um crud em springboot com os endpoints: Cadastrar, Listar, Buscar, Alterar e Excluir. Segue um resumo de cada serviço:
**Cadastrar** : EndPoint Post que recebe um json com os dados dos animais e salva na base
url: http://localhost:8080/cadastrar
Json: 
      {
          "especie":"Cao",
          "raca":"Vira Lata",
          "idade":"5",
          "cor":"Caramelo",
          "descricao":"Vira Lata Caramelo"
      }
Retorna um código Httpstatus 201.
**Alterar**   : EndPoint Put que recebe um json com os dados dos animais e salva na base
url: http://localhost:8080/alterar
Json: 
  {
      "id":8,
      "especie":"Gato",
      "raca":"Vira Lata",
      "idade":"5",
      "cor":"Preto",
      "descricao":"Gato Preto da sorte"
  }
retorna um codigo Httpstatus 200

**Listar**    : EndPoint Get que retorna uma lista com todos os animais cadastrados
url: http://localhost:8080/listar
  [
      {
          "id": 1,
          "especie": "Cao",
          "raca": "Vira Lata",
          "idade": 5,
          "cor": "Caramelo",
          "descricao": "Vira Lata Caramelo"
      }
  ]
**Buscar**    : Endpoint Get que recebe um id via url e procura pelo animal na base
url: http://localhost:8080/buscar/1
Retorno:
  {
    "id": 1,
    "especie": "Cao",
    "raca": "Vira Lata",
    "idade": 5,
    "cor": "Caramelo",
    "descricao": "Vira Lata Caramelo"
  }
**Excluir**   : Endpoint Delete que recebe o id via url e deleta os dados do animal da base.
http://localhost:8080/excluir/1
Retorna um Httpstatus 204

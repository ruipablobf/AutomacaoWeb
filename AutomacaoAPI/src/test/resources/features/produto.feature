# language: pt
Funcionalidade: Validar inserção e busca de produto via api

  Cenario: Validar inserção e busca de produto via api
    Dado que eu realizo a inserção do produto "Lápis" na api com sucesso
    Então busco um produto pelo id "1" que também está cadastrado na api

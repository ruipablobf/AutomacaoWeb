# language: pt
Funcionalidade: Validar inserção e busca de produto via api

  Cenario: Validar inserção e busca de produto via api
    Dado que eu realizo a inserção do produto "Lápis" na api com sucesso
    Então busco o produto "Hyaluronic Acid Serum" pelo id "195" também está cadastrado na api

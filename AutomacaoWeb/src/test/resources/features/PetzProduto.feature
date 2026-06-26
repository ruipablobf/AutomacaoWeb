# language: pt
  Funcionalidade: Validar valores do produto no carrinho
    Cenario: Validar valores do produto no carrinho
      Dado acesso o site petz com a url "https://www.petz.com.br/"
      E realizo a pesquisa e acesso o produto "Escada Baw & Miaw Grafite para Cães e Gatos"
      E dentro da página do produto, armazeno o valor e clico em "Adicionar à sacola"
      E acesso o carrinho clicando em "Ir para sacola"
      Então valido se os valores da página do produto é o mesmo com o valor do carrinho

package org.example.produtoapi;

public class Produto {

    ProdutoController produtoController = new ProdutoController();

    public void buscarProdutoAPI(String idProduto) {
        produtoController.buscarProduto(idProduto);
    }

    public void adicionarProdutoAPI(String nomeProduto) {
        produtoController.adicionarProduto(nomeProduto);
    }

}
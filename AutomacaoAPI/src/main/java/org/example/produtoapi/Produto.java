package org.example.produtoapi;

public class Produto extends Utilitarios{
    private int id;
    private String title;

    ProdutoController produtoController =  new ProdutoController();

    public void buscarProdutoAPI(String idProduto){
        produtoController.buscarProduto(idProduto);
    }

    public void adicionarProdutoAPI(String nomeProduto){
        produtoController.adicionarProduto(nomeProduto);
    }


}

package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import org.example.produtoapi.Produto;

public class ProdutoStepDefinitions {

    Produto produto = new Produto();

    @Dado("que eu realizo a inserção do produto {string} na api com sucesso")
    public void adicionarProdutoAPI(String nomeProduto) {
        produto.adicionarProdutoAPI(nomeProduto);
    }

    @Então("busco um produto pelo id {string} que também está cadastrado na api")
    public void buscarProdutoAPI(String nome) {
        produto.buscarProdutoAPI(nome);
    }
}
package Steps;

import Pages.Metodos;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;

public class Steps {

    Metodos metodos = new Metodos();

    @Dado("acesso o site petz com a url {string}")
    public void acessarPetz(String url) {
        metodos.abrirURL(url);
    }

    @E("realizo a pesquisa e acesso o produto {string}")
    public void pesquisaDoProduto(String nome) {
        metodos.pesquisaProduto(nome);
        metodos.acessarProdutoPesquisa(nome);
    }

    @E("dentro da página do produto, armazeno o valor e clico em {string}")
    public void armazenarValorEClicarBotao(String nome) {
        metodos.armazenarValorProdutoEClicarBotao(nome);
    }

    @E("acesso o carrinho clicando em {string}")
    public void acesarCarrinho(String nome) {
        metodos.acessarCarrinho(nome);
    }

    @Então("valido se os valores da página do produto é o mesmo com o valor do carrinho")
    public void validarValoresPaginaCarrinho(String nome) {
        metodos.armazenarValorProdutoCarrinho();
    }
}
